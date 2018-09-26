package tk.ueditor;

import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import tk.json.JsonHelper;
import tk.upload.UploadResponseVo;
import tk.upload.XFileUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-9-25.
 * 封装ueditor配置初始化、自定义上传方法
 */
public class UeditorUploadUtis {

    /**
     * 初始化ueditor配置
     * @param request
     * @return 配置json数据
     * @throws Exception
     */
    public static String initConfig(HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("utf-8");
        String rootPath = request.getRealPath("/");
        return new ActionEnter( request, rootPath ).exec();
    }

    /***
     * 文件上传
     * @param file 上传文件名，在表单提交时文件名必须是file
     * @param file 上传文件数组
     * @param  project 上传项目名
     * @param  uploadUrl 上传地址
     * @param downloadUrlPrefix 下载地址前缀
     * @return 返回上传文件UEditorUploadResponseVo
     */
    public static UEditorUploadResponseVo uploadFile(@RequestParam("file") MultipartFile[] file, String project,String uploadUrl,String downloadUrlPrefix) throws Exception{
        Map<String,InputStream> fileHashMap = Maps.newHashMap();
        for(MultipartFile f:file){
            fileHashMap.put(f.getOriginalFilename(),f.getInputStream());
        }
        Map<String,String> params = Maps.newHashMap();
        params.put("project", project);
        String result = XFileUtils.uploadFileStreamToRemoteService(fileHashMap, params, uploadUrl);
        List<UploadResponseVo> UploadResponseVoList = JsonHelper.getJsonList(result, "data", UploadResponseVo.class);
        UploadResponseVo uploadResponseVo = null;
        if(UploadResponseVoList != null && UploadResponseVoList.size() > 0) {
            uploadResponseVo = UploadResponseVoList.get(0);
        }
        UEditorUploadResponseVo uEditorUploadResponseVo = new UEditorUploadResponseVo();
        uEditorUploadResponseVo.setState(uploadResponseVo.getState());
        uEditorUploadResponseVo.setSize(uploadResponseVo.getFileSize());
        uEditorUploadResponseVo.setType(uploadResponseVo.getFileType());
        uEditorUploadResponseVo.setOriginal(uploadResponseVo.getFileName());
        uEditorUploadResponseVo.setTitle(uploadResponseVo.getFileName());
        uEditorUploadResponseVo.setUrl(downloadUrlPrefix+uploadResponseVo.getFilePath());
        return uEditorUploadResponseVo;
    }
}

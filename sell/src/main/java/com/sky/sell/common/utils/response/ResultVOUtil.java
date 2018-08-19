package com.sky.sell.common.utils.response;

import com.sky.sell.vo.ResultVO;

public class ResultVOUtil {

	public static ResultVO success(Object object) {
		ResultVO resultVO = new ResultVO();
		resultVO.setCode(0);
		resultVO.setMsg("成功");
		resultVO.setData(object);
		return resultVO;
	}
	
	public static ResultVO success() {
		return success(null);
	}
	
	public static ResultVO error(Integer code,String message) {
		ResultVO resultVO = new ResultVO();
		resultVO.setCode(code);
		resultVO.setMsg(message);
		return resultVO;
	}
	
}

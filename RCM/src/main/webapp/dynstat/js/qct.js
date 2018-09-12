function bar1(cfg){
	var seriesarr=[];
	for(var i=0;i<cfg.series.length;i++){
		seriesarr.push({
          name: cfg.series[i].name,
          type: 'bar',
          data: cfg.series[i].data
      	});
		seriesarr.push({
          name: cfg.series[i].name+"L",
          type: 'line',
          data: cfg.series[i].data
      	});
	}
	var option = {
      title: {
          text: cfg.title
      },
      tooltip: {},
      legend: {
          data:cfg.legend
      },
      xAxis: {
          data: cfg.xAxis
      },
      yAxis: {},
      series: seriesarr
  	};
	this.echart = echarts.init(cfg.dom,cfg.theme);
  	this.echart.setOption(option);
  	this.echart.resize();
}

function bar2(cfg){
	var seriesarr=[];
	for(var i=0;i<cfg.series.length;i++){
		seriesarr.push({
          name: cfg.series[i].name,
          type: 'bar',
          stack: '总量',
          label: {
              normal: {
                  show: true,
                  position: 'insideRight'
              }
          },
          data: cfg.series[i].data
      	});
	}
	var option = {
		title: {
	          text: cfg.title
	    },
	    tooltip : {
	        trigger: 'axis',
	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
	            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
	        }
	    },
	    legend: {
	        data: cfg.legend
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    xAxis:  {
	        type: 'value'
	    },
	    yAxis: {
	        type: 'category',
	        data: cfg.yAxis
	    },
	    series:seriesarr
	};
	this.echart = echarts.init(cfg.dom,cfg.theme);
	this.echart.setOption(option);
}

function bar3(cfg){
	var seriesarr=[];
	for(var i=0;i<cfg.series.length;i++){
		seriesarr.push({
          name: cfg.series[i].name,
          type: 'bar',
          data: cfg.series[i].data
      	});
	}
	var option = {
	    color: ['#3398DB'],
	    title: {
	          text: cfg.title
	    },
	    legend: {
	          data:cfg.legend
	    },
	    tooltip : {
	        trigger: 'axis',
	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
	            type : 'line'        // 默认为直线，可选为：'line' | 'shadow'
	        }
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    xAxis : [
	        {
	            type : 'category',
	            data : cfg.xAxis,
	            axisTick: {
	                alignWithLabel: true
	            }
	        }
	    ],
	    yAxis : [
	        {
	            type : 'value'
	        }
	    ],
	    series: seriesarr
	};
	this.echart = echarts.init(cfg.dom,cfg.theme);
	this.echart.setOption(option);
}

function scatter1(cfg){
	var schema = cfg.schema;
	var itemStyle = {
	    normal: {
	        opacity: 0.8,
	        shadowBlur: 10,
	        shadowOffsetX: 0,
	        shadowOffsetY: 0,
	        shadowColor: 'rgba(0, 0, 0, 0.5)'
	    }
	};
	var seriesarr=[];
	for(var i=0;i<cfg.series.length;i++){
		seriesarr.push({
	         name: cfg.series[i].name,
	         type: 'scatter',
	         itemStyle: itemStyle,
	         data: cfg.series[i].data
	    });
	}
	var option = {
	    title: {
	          text: cfg.title
	    },
	    legend: {
	        y: 'top',
	        data: cfg.legend,
	        textStyle: {
	        }
	    },
	    grid: {
	        x: '10%',
	        x2: 150,
	        y: '18%',
	        y2: '10%'
	    },
	    tooltip: {
	        padding: 10,
	        borderWidth: 1,
	        formatter: function (obj) {
	            var value = obj.value;
	            return '<div style="border-bottom: 1px solid rgba(255,255,255,.3); font-size: 18px;padding-bottom: 7px;margin-bottom: 7px">'
	                + obj.seriesName + ' ' + value[0] + '日：' + value[7]
	                + '</div>'
	                + schema[1].text + '：' + value[1] + '<br>'
	                + schema[2].text + '：' + value[2] + '<br>'
	                + schema[3].text + '：' + value[3] + '<br>'
	                + schema[4].text + '：' + value[4] + '<br>'
	                + schema[5].text + '：' + value[5] + '<br>'
	                + schema[6].text + '：' + value[6] + '<br>';
	        }
	    },
	    xAxis: {
	        type: 'value',
	        name: cfg.xAxis,
	        nameGap: 16,
	        nameTextStyle: {
	        },
	        max: 31,
	        splitLine: {
	            show: false
	        },
	        axisLine: {
	            lineStyle: {
	            }
	        }
	    },
	    yAxis: {
	        type: 'value',
	        name: cfg.yAxis,
	        nameLocation: 'end',
	        nameGap: 20,
	        nameTextStyle: {
	        },
	        axisLine: {
	            lineStyle: {
	            }
	        },
	        splitLine: {
	            show: false
	        }
	    },
	    visualMap: [
	        {
	            left: 'right',
	            top: '0%',
	            dimension: 2,
	            min: 0,
	            max: 250,
	            itemWidth: 30,
	            itemHeight: 120,
	            calculable: true,
	            precision: 0.1,
	            text: ['圆形大小'],
	            textGap: 30,
	            textStyle: {
	            },
	            inRange: {
	                symbolSize: [10, 70]
	            },
	            outOfRange: {
	                symbolSize: [10, 70],
	                color: ['rgba(255,255,255,.2)']
	            },
	            controller: {
	                inRange: {
	                    color: ['#c23531']
	                },
	                outOfRange: {
	                    color: ['#444']
	                }
	            }
	        },
	        {
	            left: 'right',
	            bottom: '0%',
	            dimension: 6,
	            min: 0,
	            max: 50,
	            itemHeight: 120,
	            calculable: true,
	            precision: 0.1,
	            text: ['明暗'],
	            textGap: 30,
	            textStyle: {
	                color: '#fff'
	            },
	            inRange: {
	                colorLightness: [1, 0.5]
	            },
	            outOfRange: {
	                color: ['rgba(255,255,255,.2)']
	            },
	            controller: {
	                inRange: {
	                    color: ['#c23531']
	                },
	                outOfRange: {
	                    color: ['#444']
	                }
	            }
	        }
	    ],
	    series:seriesarr
	};

	this.echart = echarts.init(cfg.dom,cfg.theme);
	this.echart.setOption(option);
}

function line1(cfg){
	var seriesarr=[];
	for(var i=0;i<cfg.series.length;i++){
		seriesarr.push({
	         name: cfg.series[i].name,
	         type: 'line',
	         stack: '总量',
	         areaStyle: {normal: {}},
	         data: cfg.series[i].data
	     	});
	}
	var option = {
	    title: {
	        text: cfg.title
	    },
	    tooltip : {
	        trigger: 'axis',
	        axisPointer: {
	            type: 'cross'
	        }
	    },
	    legend: {
	        data:cfg.legend
	    },
	    toolbox: {
	        feature: {
	            saveAsImage: {}
	        }
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    xAxis : {
	        type : 'category',
	        boundaryGap : false,
	        data : cfg.xAxis
	    },
	    yAxis : [
	        {
	            type : 'value'
	        }
	    ],
	    series :seriesarr
	};
	this.echart = echarts.init(cfg.dom,cfg.theme);
	this.echart.setOption(option);
}

function line2(cfg){
	var data = cfg.series[0].data;

	// See https://github.com/ecomfe/echarts-stat
	var myRegression = ecStat.regression('exponential', data);

	myRegression.points.sort(function(a, b) {
	    return a[0] - b[0];
	});

	var option = {
	    title: {
	        text: cfg.title,
	        subtext: '',
	        sublink: '',
	        left: 'center'
	    },
	    tooltip: {
	        trigger: 'axis',
	        axisPointer: {
	            type: '',
	        }
	    },
	    xAxis: {
	        type: 'value',
	        splitLine: {
	            lineStyle: {
	                type: 'dashed'
	            }
	        },
	        axisLine:{
	        	
	        },
	        splitNumber: 20
	    },
	    yAxis: {
	        type: 'value',
	        splitLine: {
	            lineStyle: {
	                type: 'solid'
	            }
	        },
	        axisLine:{
	        	
	        },
	    },
	    series: [{
	        name: cfg.series[0].name,
	        type: 'scatter',
	        itemStyle:{
	        	
	        },
	        label: {
	            emphasis: {
	                show: true,
	                position: 'left'
	            }
	        },
	        data: data
	    }, {
	        name: '拟合',
	        type: 'line',
	        showSymbol: false,
	        smooth: true,
	        data: myRegression.points,
	        markPoint: {
	            itemStyle: {
	                normal: {
	                    color: 'transparent'
	                }
	            },
	            label: {
	                normal: {
	                    show: true,
	                    position: 'left',
	                    formatter: myRegression.expression
	                }
	            },
	            data: [{
	                coord: myRegression.points[myRegression.points.length - 1]
	            }]
	        }
	    }]
	};

	this.echart = echarts.init(cfg.dom,cfg.theme);
	this.echart.setOption(option);
}

function pie1(cfg){
	var data = cfg.series[0].data;

	var option = {
	    title : {
	        text: cfg.title,
	        subtext: cfg.subtext,
	        x:'center'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    legend: {
	        orient: 'vertical',
	        left: 'left',
	        data: cfg.legend
	    },
	    series : [
	        {
	            name: '访问来源',
	            type: 'pie',
	            radius : '55%',
	            center: ['50%', '60%'],
	            data:data,
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};

	this.echart = echarts.init(cfg.dom,cfg.theme);
	this.echart.setOption(option);
}

function circle1(cfg){
	var data = cfg.series[0].data;

	var option = {
	    tooltip: {
	        trigger: 'item',
	        formatter: "{a} <br/>{b}: {c} ({d}%)"
	    },
	    legend: {
	        orient: 'vertical',
	        x: 'left',
	        data:cfg.legend
	    },
	    series: [
	        {
	            name:cfg.series[0].name,
	            type:'pie',
	            radius: ['50%', '70%'],
	            avoidLabelOverlap: false,
	            label: {
	                normal: {
	                    show: false,
	                    position: 'center'
	                },
	                emphasis: {
	                    show: true,
	                    textStyle: {
	                        fontSize: '30',
	                        fontWeight: 'bold'
	                    }
	                }
	            },
	            labelLine: {
	                normal: {
	                    show: false
	                }
	            },
	            data:data
	        }
	    ]
	};

	this.echart = echarts.init(cfg.dom,cfg.theme);
	this.echart.setOption(option);
}

function rose1(cfg){
	var data = cfg.series[0].data;

	var option = {
	    //backgroundColor: '#2c343c',

	    title: {
	        text: cfg.title,
	        left: 'center',
	        top: 20,
	        textStyle: {
	            //color: '#ccc'
	        }
	    },

	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },

	    visualMap: {
	        show: false,
	        min: 80,
	        max: 600,
	        inRange: {
	            //colorLightness: [0, 1]
	        }
	    },
	    series : [
	        {
	            name:cfg.series[0].name,
	            type:'pie',
	            radius : '55%',
	            center: ['50%', '50%'],
	            data:data.sort(function (a, b) { return a.value - b.value; }),
	            roseType: 'radius',
	            label: {
	                normal: {
	                    textStyle: {
	                        //color: 'rgba(255, 255, 255, 0.3)'
	                    }
	                }
	            },
	            labelLine: {
	                normal: {
	                    lineStyle: {
	                        //color: 'rgba(255, 255, 255, 0.3)'
	                    },
	                    smooth: 0.2,
	                    length: 10,
	                    length2: 20
	                }
	            },
	            itemStyle: {
	                normal: {
	                    //color: '#c23531',
	                    shadowBlur: 200,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            },

	            animationType: 'scale',
	            animationEasing: 'elasticOut',
	            animationDelay: function (idx) {
	                return Math.random() * 200;
	            }
	        }
	    ]
	};

	this.echart = echarts.init(cfg.dom,cfg.theme);
	this.echart.setOption(option);
}

function radar1(cfg){
	var data = cfg.series[0].data;

	var option = {
	    title: {
	        text:cfg.title
	    },
	    tooltip: {},
	    legend: {
	        data: cfg.legend
	    },
	    radar: {
	        // shape: 'circle',
	        indicator: cfg.indicator
	    },
	    series: [{
	        name: cfg.series[0].name,
	        type: 'radar',
	        areaStyle: {normal: {}},
	        data : data
	    }]
	};

	this.echart = echarts.init(cfg.dom,cfg.theme);
	this.echart.setOption(option);
}

function gis1(cfg){
	var data = cfg.series[0].data;
	var geoCoordMap = {
	    '海门':[121.15,31.89],
	    '鄂尔多斯':[109.781327,39.608266],
	    '招远':[120.38,37.35],
	    '舟山':[122.207216,29.985295],
	    '齐齐哈尔':[123.97,47.33],
	    '盐城':[120.13,33.38],
	    '赤峰':[118.87,42.28],
	    '青岛':[120.33,36.07],
	    '乳山':[121.52,36.89],
	    '金昌':[102.188043,38.520089],
	    '泉州':[118.58,24.93],
	    '莱西':[120.53,36.86],
	    '日照':[119.46,35.42],
	    '胶南':[119.97,35.88],
	    '南通':[121.05,32.08],
	    '拉萨':[91.11,29.97],
	    '云浮':[112.02,22.93],
	    '梅州':[116.1,24.55],
	    '文登':[122.05,37.2],
	    '上海':[121.48,31.22],
	    '攀枝花':[101.718637,26.582347],
	    '威海':[122.1,37.5],
	    '承德':[117.93,40.97],
	    '厦门':[118.1,24.46],
	    '汕尾':[115.375279,22.786211],
	    '潮州':[116.63,23.68],
	    '丹东':[124.37,40.13],
	    '太仓':[121.1,31.45],
	    '曲靖':[103.79,25.51],
	    '烟台':[121.39,37.52],
	    '福州':[119.3,26.08],
	    '瓦房店':[121.979603,39.627114],
	    '即墨':[120.45,36.38],
	    '抚顺':[123.97,41.97],
	    '玉溪':[102.52,24.35],
	    '张家口':[114.87,40.82],
	    '阳泉':[113.57,37.85],
	    '莱州':[119.942327,37.177017],
	    '湖州':[120.1,30.86],
	    '汕头':[116.69,23.39],
	    '昆山':[120.95,31.39],
	    '宁波':[121.56,29.86],
	    '湛江':[110.359377,21.270708],
	    '揭阳':[116.35,23.55],
	    '荣成':[122.41,37.16],
	    '连云港':[119.16,34.59],
	    '葫芦岛':[120.836932,40.711052],
	    '常熟':[120.74,31.64],
	    '东莞':[113.75,23.04],
	    '河源':[114.68,23.73],
	    '淮安':[119.15,33.5],
	    '泰州':[119.9,32.49],
	    '南宁':[108.33,22.84],
	    '营口':[122.18,40.65],
	    '惠州':[114.4,23.09],
	    '江阴':[120.26,31.91],
	    '蓬莱':[120.75,37.8],
	    '韶关':[113.62,24.84],
	    '嘉峪关':[98.289152,39.77313],
	    '广州':[113.23,23.16],
	    '延安':[109.47,36.6],
	    '太原':[112.53,37.87],
	    '清远':[113.01,23.7],
	    '中山':[113.38,22.52],
	    '昆明':[102.73,25.04],
	    '寿光':[118.73,36.86],
	    '盘锦':[122.070714,41.119997],
	    '长治':[113.08,36.18],
	    '深圳':[114.07,22.62],
	    '珠海':[113.52,22.3],
	    '宿迁':[118.3,33.96],
	    '咸阳':[108.72,34.36],
	    '铜川':[109.11,35.09],
	    '平度':[119.97,36.77],
	    '佛山':[113.11,23.05],
	    '海口':[110.35,20.02],
	    '江门':[113.06,22.61],
	    '章丘':[117.53,36.72],
	    '肇庆':[112.44,23.05],
	    '大连':[121.62,38.92],
	    '临汾':[111.5,36.08],
	    '吴江':[120.63,31.16],
	    '石嘴山':[106.39,39.04],
	    '沈阳':[123.38,41.8],
	    '苏州':[120.62,31.32],
	    '茂名':[110.88,21.68],
	    '嘉兴':[120.76,30.77],
	    '长春':[125.35,43.88],
	    '胶州':[120.03336,36.264622],
	    '银川':[106.27,38.47],
	    '张家港':[120.555821,31.875428],
	    '三门峡':[111.19,34.76],
	    '锦州':[121.15,41.13],
	    '南昌':[115.89,28.68],
	    '柳州':[109.4,24.33],
	    '三亚':[109.511909,18.252847],
	    '自贡':[104.778442,29.33903],
	    '吉林':[126.57,43.87],
	    '阳江':[111.95,21.85],
	    '泸州':[105.39,28.91],
	    '西宁':[101.74,36.56],
	    '宜宾':[104.56,29.77],
	    '呼和浩特':[111.65,40.82],
	    '成都':[104.06,30.67],
	    '大同':[113.3,40.12],
	    '镇江':[119.44,32.2],
	    '桂林':[110.28,25.29],
	    '张家界':[110.479191,29.117096],
	    '宜兴':[119.82,31.36],
	    '北海':[109.12,21.49],
	    '西安':[108.95,34.27],
	    '金坛':[119.56,31.74],
	    '东营':[118.49,37.46],
	    '牡丹江':[129.58,44.6],
	    '遵义':[106.9,27.7],
	    '绍兴':[120.58,30.01],
	    '扬州':[119.42,32.39],
	    '常州':[119.95,31.79],
	    '潍坊':[119.1,36.62],
	    '重庆':[106.54,29.59],
	    '台州':[121.420757,28.656386],
	    '南京':[118.78,32.04],
	    '滨州':[118.03,37.36],
	    '贵阳':[106.71,26.57],
	    '无锡':[120.29,31.59],
	    '本溪':[123.73,41.3],
	    '克拉玛依':[84.77,45.59],
	    '渭南':[109.5,34.52],
	    '马鞍山':[118.48,31.56],
	    '宝鸡':[107.15,34.38],
	    '焦作':[113.21,35.24],
	    '句容':[119.16,31.95],
	    '北京':[116.46,39.92],
	    '徐州':[117.2,34.26],
	    '衡水':[115.72,37.72],
	    '包头':[110,40.58],
	    '绵阳':[104.73,31.48],
	    '乌鲁木齐':[87.68,43.77],
	    '枣庄':[117.57,34.86],
	    '杭州':[120.19,30.26],
	    '淄博':[118.05,36.78],
	    '鞍山':[122.85,41.12],
	    '溧阳':[119.48,31.43],
	    '库尔勒':[86.06,41.68],
	    '安阳':[114.35,36.1],
	    '开封':[114.35,34.79],
	    '济南':[117,36.65],
	    '德阳':[104.37,31.13],
	    '温州':[120.65,28.01],
	    '九江':[115.97,29.71],
	    '邯郸':[114.47,36.6],
	    '临安':[119.72,30.23],
	    '兰州':[103.73,36.03],
	    '沧州':[116.83,38.33],
	    '临沂':[118.35,35.05],
	    '南充':[106.110698,30.837793],
	    '天津':[117.2,39.13],
	    '富阳':[119.95,30.07],
	    '泰安':[117.13,36.18],
	    '诸暨':[120.23,29.71],
	    '郑州':[113.65,34.76],
	    '哈尔滨':[126.63,45.75],
	    '聊城':[115.97,36.45],
	    '芜湖':[118.38,31.33],
	    '唐山':[118.02,39.63],
	    '平顶山':[113.29,33.75],
	    '邢台':[114.48,37.05],
	    '德州':[116.29,37.45],
	    '济宁':[116.59,35.38],
	    '荆州':[112.239741,30.335165],
	    '宜昌':[111.3,30.7],
	    '义乌':[120.06,29.32],
	    '丽水':[119.92,28.45],
	    '洛阳':[112.44,34.7],
	    '秦皇岛':[119.57,39.95],
	    '株洲':[113.16,27.83],
	    '石家庄':[114.48,38.03],
	    '莱芜':[117.67,36.19],
	    '常德':[111.69,29.05],
	    '保定':[115.48,38.85],
	    '湘潭':[112.91,27.87],
	    '金华':[119.64,29.12],
	    '岳阳':[113.09,29.37],
	    '长沙':[113,28.21],
	    '衢州':[118.88,28.97],
	    '廊坊':[116.7,39.53],
	    '菏泽':[115.480656,35.23375],
	    '合肥':[117.27,31.86],
	    '武汉':[114.31,30.52],
	    '大庆':[125.03,46.58]
	};
	
	var convertData = function (data) {
	    var res = [];
	    for (var i = 0; i < data.length; i++) {
	        var geoCoord = geoCoordMap[data[i].name];
	        if (geoCoord) {
	            res.push({
	                name: data[i].name,
	                value: geoCoord.concat(data[i].value)
	            });
	        }
	    }
	    return res;
	};
	
	var option = {
	    //backgroundColor: '#404a59',
	    title: {
	        text:cfg.title,
	        subtext: '',
	        sublink: '',
	        left: 'center',
	        textStyle: {
	            //color: '#fff'
	        }
	    },
	    tooltip : {
	        padding: 10,
	        //backgroundColor: '#222',
	        //borderColor: '#777',
	        borderWidth: 1,
	        formatter: function (obj) {
	            return '<div style="border-bottom: 1px solid rgba(255,255,255,.3); font-size: 18px;padding-bottom: 7px;margin-bottom: 7px">'
	                + obj.name + ' ' + obj.value[2] + '' ;
	        }
	    },
	    legend: {
	        orient: 'vertical',
	        data:['pm2.5'],
	        textStyle: {
	            //color: '#000'
	        }
	    },
	    geo: {
	        map: 'china',
	        label: {
	            emphasis: {
	                show: false
	            }
	        },
	        roam: true,
	        itemStyle: {
	            normal: {
	                //areaColor: '#323c48',
	                //borderColor: '#111'
	            },
	            emphasis: {
	                //areaColor: '#2a333d'
	            }
	        }
	    },
	    series : [
	        {
	            name: cfg.series[0].name,
	            type: 'scatter',
	            coordinateSystem: 'geo',
	            data: convertData(data),
	            symbolSize: function (val) {
	                return val[2] / 10;
	            },
	            label: {
	                normal: {
	                    formatter: '{b}',
	                    position: 'right',
	                    show: false
	                },
	                emphasis: {
	                    show: true
	                }
	            },
	            itemStyle: {
	                normal: {
	                    //color: '#ddb926'
	                }
	            }
	        },
	        {
	            name: 'Top 5',
	            type: 'effectScatter',
	            coordinateSystem: 'geo',
	            data: convertData(data.sort(function (a, b) {
	                return b.value - a.value;
	            }).slice(0, 6)),
	            symbolSize: function (val) {
	                return val[2] / 10;
	            },
	            showEffectOn: 'render',
	            rippleEffect: {
	                brushType: 'stroke'
	            },
	            hoverAnimation: true,
	            label: {
	                normal: {
	                    formatter: '{b}',
	                    position: 'right',
	                    show: true
	                }
	            },
	            itemStyle: {
	                normal: {
	                    //color: '#f4e925',
	                    shadowBlur: 10,
	                    shadowColor: '#333'
	                }
	            },
	            zlevel: 1
	        }
	    ]
	};
	
	$.get('./js/china.json', function (chinaJson) {
	    echarts.registerMap('china', chinaJson);
	    var chart = echarts.init(cfg.dom,cfg.theme);
	    chart.setOption(option);
	});
}
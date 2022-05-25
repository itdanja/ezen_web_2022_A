
let jsonlist;

$( function(){ 
	$.ajax({
		url : "/jspweb/admin/getchart",
		success : function( re ){
			console.log( re );
			jsonlist = re;
			
			//////////////////////////////////////  에이엠차트 ///////////////////////////////////
				am5.ready(function() {
				
				// Create root element
				// https://www.amcharts.com/docs/v5/getting-started/#Root_element
				var root = am5.Root.new("chartdiv");
				
				// Set themes
				// https://www.amcharts.com/docs/v5/concepts/themes/
				root.setThemes([
				  am5themes_Animated.new(root)
				]);
				
				
				// Create chart
				// https://www.amcharts.com/docs/v5/charts/xy-chart/
				var chart = root.container.children.push(am5xy.XYChart.new(root, {
				  panX: false,
				  panY: false,
				  wheelX: "panX",
				  wheelY: "zoomX"
				}));
				
				
				// Add cursor
				// https://www.amcharts.com/docs/v5/charts/xy-chart/cursor/
				var cursor = chart.set("cursor", am5xy.XYCursor.new(root, {
				  behavior: "zoomX"
				}));
				cursor.lineY.set("visible", false);
				
				// var date = new Date();
				// date.setHours(0, 0, 0, 0);
				// var value = 100;
				
				function generateData(i) {
				  // 1. i번째 객체에서 값 가져오기 
				  	// * 문자열 -> 정수형식  [  parseInt( "문자열" )   ]
				  let value = parseInt( jsonlist[i]["value"] );
				  // 2. i번째 객체에서 날짜 가져오기 
				  	// * 문자열 -> 날짜형식  [  new Date( "문자열" );  ]
				  	
				  let date = new Date( jsonlist[i]["date"] );
				  
				  date.setHours(0, 0, 0, 0);
				  
				  am5.time.add(date, "day", 1);
				  return {
				    date: date.getTime(),
				    value: value
				  };
				  
				}
				
				function generateDatas(count) {
				  var data = [];
				  for (var i = 0; i < count; ++i) {
				    data.push( generateData(i) ); // 객체 인덱스번호 i 를 인수로 전달 
				  }
				  return data;
				}
				
				
				// Create axes
				// https://www.amcharts.com/docs/v5/charts/xy-chart/axes/
				var xAxis = chart.xAxes.push(am5xy.DateAxis.new(root, {
				  maxDeviation: 0,
				  baseInterval: {
				    timeUnit: "day",
				    count: 1
				  },
				  renderer: am5xy.AxisRendererX.new(root, {}),
				  tooltip: am5.Tooltip.new(root, {})
				}));
				
				var yAxis = chart.yAxes.push(am5xy.ValueAxis.new(root, {
				  renderer: am5xy.AxisRendererY.new(root, {})
				}));
				
				
				// Add series
				// https://www.amcharts.com/docs/v5/charts/xy-chart/series/
				var series = chart.series.push(am5xy.ColumnSeries.new(root, {
				  name: "Series",
				  xAxis: xAxis,
				  yAxis: yAxis,
				  valueYField: "value",
				  valueXField: "date",
				  tooltip: am5.Tooltip.new(root, {
				    labelText: "{valueY}"
				  })
				}));
				
				
				
				// Add scrollbar
				// https://www.amcharts.com/docs/v5/charts/xy-chart/scrollbars/
				chart.set("scrollbarX", am5.Scrollbar.new(root, {
				  orientation: "horizontal"
				}));
				
				var data = generateDatas( jsonlist.length ); // 1. 차트에 들어가는 데이터 [ 인수 : 객체수 ]
				series.data.setAll(data);
				
				
				// Make stuff animate on load
				// https://www.amcharts.com/docs/v5/concepts/animations/
				series.appear(1000);
				chart.appear(1000, 100);
				
				}); // end am5.ready()
				//////////////////////////////////////////////////////////////////////////////////////
							
			
		}
	});
});



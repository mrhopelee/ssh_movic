/// <reference path="../typings/jquery/jquery.d.ts"/>

$(document)
		.ready(
				function() { /* 选取元素 */
					var btn_prev = $("#btn_prev"), 
						btn_next = $("#btn_next"), 
						body = $("body"), 
						photoshow = $("#photoshow a"), 
						a, b,
						temp0, temp1, 
						remp0,remp1,
						/*
						 * test_name = $("#test_name"), test_grade =
						 * $("#test_grade"), test_content = $("#test_content"),
						 * test_class = $("#test_class"), singers =
						 * $("#singers"),
						 */
						img_num = 1, 
						img_str = " ",
						rdiv = $(".photoshowbottom div"),
						hiddenshadow= $(".hiddenshadow");
					
						
					rdiv.click(function() {
						
						a = img_num;
						b = $(this).index()+1;
						if(a==b){}else{
							hiddenshadowfun(hiddenshadow);
							
							// alert(a+" "+b);
							temp0 = photoshow.eq(img_num - 1);
							temp1 = photoshow.eq($(this).index());
							remp0 = rdiv.eq(img_num - 1);
							remp1 = rdiv.eq($(this).index());
							img_num=b;
							
							remp0.css({
								"border" : "4px solid #ccc",
								"cursor" : "pointer"
							});
							remp1.css({
								"border" : "4px solid #4C9ED9",
								"cursor" : "unset"
							});
							
							photoshowInit(photoshow, a, b);
							temp0.stop().fadeTo(800, 0, function() {
								temp0.css({
									"opacity" : "0",
									"z-index" : "7",
									"display" : "none"
								});
							});
							temp1.stop().fadeTo(800, 1, function() {
								temp1.css({
									"z-index" : "8",
									"display" : "block"
								});							
							});						
						}
					})
					/* 两个按钮的点击事件 */
					btn_prev.click(function() {/* img_num给图片编号，控制图片变化。 */
						hiddenshadowfun(hiddenshadow);
						if (img_num == 1) {
							img_num = 5;
							a = 1;
							b = 5;

							temp0 = photoshow.eq(0);
							temp1 = photoshow.eq(img_num - 1);
							remp0 = rdiv.eq(0);
							remp1 = rdiv.eq(img_num - 1);
						} else {
							img_num = img_num - 1;
							a = img_num + 1;
							b = img_num;

							temp0 = photoshow.eq(img_num);
							temp1 = photoshow.eq(img_num - 1);
							remp0 = rdiv.eq(img_num);
							remp1 = rdiv.eq(img_num - 1);
						}
						remp0.css({
							"border" : "4px solid #ccc",
							"cursor" : "pointer"
						});
						remp1.css({
							"border" : "4px solid #4C9ED9",
							"cursor" : "unset"
						});
						photoshowInit(photoshow, a, b);
						temp0.stop().fadeTo(800, 0, function() {
							temp0.css({
								"opacity" : "0",
								"z-index" : "7",
								"display" : "none"
							});
						});
						temp1.stop().fadeTo(800, 1, function() {
							temp1.css({
								"z-index" : "8",
								"display" : "block"
							});
						});

						img_str = "url(image/主页/bg" + img_num + ".jpg)";
					});
					btn_next.click(function() {
						hiddenshadowfun(hiddenshadow);
						if (img_num == 5) {
							img_num = 1;

							a = 1;
							b = 5;

							temp0 = photoshow.eq(4);
							temp1 = photoshow.eq(img_num - 1);
							remp0 = rdiv.eq(4);
							remp1 = rdiv.eq(img_num - 1);
						} else {
							img_num = img_num + 1;

							a = img_num - 1;
							b = img_num;

							temp0 = photoshow.eq(img_num - 2);
							temp1 = photoshow.eq(img_num - 1);
							remp0 = rdiv.eq(img_num - 2);
							remp1 = rdiv.eq(img_num - 1);
						}
						
						remp0.css({
							"border" : "4px solid #ccc",
							"cursor" : "pointer"
						});
						remp1.css({
							"border" : "4px solid #4C9ED9",
							"cursor" : "unset"
						});
						photoshowInit(photoshow, a, b);
						temp0.stop().fadeTo(800, 0, function() {
							temp0.css({
								"opacity" : "0",
								"z-index" : "7",
								"display" : "none"
							});
						});
						temp1.stop().fadeTo(800, 1, function() {
							temp1.css({
								"z-index" : "8",
								"display" : "block"
							});
						});

						img_str = "url(image/主页/bg" + img_num + ".jpg)";
					});
				});
function hiddenshadowfun(hiddenshadow){
	hiddenshadow.css({
		"display":"block"
	});
	setTimeout(function() {

		　　hiddenshadow.css({
			"display":"none"
		});

		　　}, 1000);
}
function photoshowInit(photoshow, a, b) {
	for (var index = photoshow.length; index > 0; index--) {
		if (index == a || index == b) {

		} else {
			var element = photoshow.eq(index - 1);
			element.stop().css({
				"opacity" : "0",
				"z-index" : "7",
				"display" : "none"
			});

		}

	}
}
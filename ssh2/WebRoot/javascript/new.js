/// <reference path="../typings/jquery/jquery.d.ts"/>

$(document).ready( function ()
	{   /* 选取元素 */
         var btn_prev=$("#btn_prev"),
            btn_next=$("#btn_next"),
            body=$("body"),
            photoshow=$("#photoshow a"),
            a,b,temp0,temp1,
            test_name=$("#test_name"),
            test_grade=$("#test_grade"),
            test_content=$("#test_content"),
            test_class=$("#test_class"),
            singers=$("#singers"),
            img_num=1,
            img_str=" ";
        /* 定义json数组 */
        var music_text = [
        
            {"song":"音乐/music_oursong.html",
             "testName":"Our song",
            "testGrade":"豆瓣评分:★★★★★",
            "testContent":"美国乡村音乐女创作歌手泰勒斯威夫特于2007年8月22日正式打单的一支单曲，收录于其第一张个人录音室专辑中，歌曲于billboard hot100中取得最高16名的成绩。另外，挪威组合m2m，Plain White Ts和MB20都有同名歌曲。",
            "testClass":"分类：欧美/乡村", 
            "testMusician":"Taylor Swift",
            "singers":"singer/singer_info_TaylorSwift.html"},
            
            {"song":"音乐/music_themass.html",
             "testName":"The Mass",
            "testGrade":"豆瓣评分:★★★★",
            "testContent":"“The Mass”这首歌是由一个叫“Era”的现代乐团所唱的。《The Mass》传承了Eric Levi自首张专辑《Era》起便汲汲经营的音乐特色，匠心独具的融合流行、摇滚及古典乐，经过截枝去叶后而产生简洁有力的音乐风格，让人听起来有一种振奋人心的感觉，就像是为胜利者凯旋而归的赞美曲。为了超越经典，Eric Levi更撷取德国知名音乐家Carl Orff/卡尔·奥福最受盛赞的作品《Carmina Burana/布兰诗歌》，为首发同名单曲“The Mass”的主体。",
            "testClass":"分类:流行/摇滚/古典", 
            "testMusician":"Era",
            "singers":"singer/singer_info_EasonChan.html"},
            
            {"song":"音乐/music_amazing.html", 
            "testName":"Amazing",
            "testGrade":"豆瓣评分:★★★★",
            "testContent":"坎耶·欧马立·韦斯特（Kanye Omari West，1977年6月8日-），是一位美国的饶舌歌手、唱片制作人、作家和歌手，目前为止共发行了四张专辑。在2008年5月16日，坎耶·韦斯特获得MTV电视台选为该年度“最热门饶舌歌手”。这首Amazing以强烈的节奏和激昂的歌词，被NBA选为广告宣传的背景音乐，是许多运动青年的挚爱。",
            "testClass":"分类:流行/嘻哈" ,
            "testMusician":"Kanye West",
            "singers":"singer/singer_info_KanyeWest.html" },
            
            { "song":"音乐/music_lucky.html",
                "testName":"Lucky",
            "testGrade":"豆瓣评分:★★★★",
            "testContent":"Jason Mraz & Colbie Caillat演唱的歌曲《Lucky》，以轻快柔美的旋律和两位演唱者动听的声音征服了严格的格莱美评委们，获得了2010年第52届格莱美最佳流行合作歌曲。",
            "testClass":"分类:乡村/欧美",
            "testMusician":"Jason Mraz",
            "singers":"singer/singer_info_JasonMraz.html"},
            
            { "song":"音乐/music_youraisemeup.html",
                "testName":"You Raise Me Up",
            "testGrade":"豆瓣评分:★★★★",
            "testContent":"You Raise Me Up这首歌是一首赞美诗，事实上是歌颂上帝，告诫人们在任何艰难压抑的情况下，靠着上帝胜过自己、胜过环境的“福音类”的歌。间奏的风笛更是让人深陷音乐深海之中无法自拔，作为少有的励志和感恩音乐，最后的合唱气势磅礴，坚定有力。其中有一句You raise me up, to walk on stormy seas，是从《圣经》的典故而来----耶稣走在海面上。中文意思简单可翻译为“是你鼓舞了我”，是一支由New Age Music乐队Secret Garden（神秘园）演唱的歌曲名称，被多次翻唱。",
            "testClass":"分类:传统/新世纪",
            "testMusician":"WestLife" ,
            "singers":"singer/singer_info_WestLift.html"},
            
            ];
        /* 两个按钮的点击事件 */
        btn_prev.click(function(){/* img_num给图片编号，控制图片变化。*/
            
            if(img_num==1){
                img_num=5;
                a=1;
                b=5;
                
                temp0 = photoshow.eq(0);
                temp1 = photoshow.eq(img_num-1);
            }else{
                img_num=img_num-1;            
                a=img_num;
                b=img_num+1;
                
                temp0 = photoshow.eq(img_num);
                temp1 = photoshow.eq(img_num-1);
            }
            //new.html
            
            photoshowInit(photoshow,a,b);
            temp0.stop().fadeTo(800,0,function(){
                temp0.css({
                "opacity":"0",
                "z-index":"7",
                "display":"none"
            });
            });
            temp1.stop().fadeTo(800,1,function(){
                temp1.css({
                    "z-index":"8",
                    "display":"block"
                });
            });
            
            
            test_name.text(music_text[img_num-1].testName);/* text()为改变文档，attr()改变属性，css()改变样式 */
            test_name.attr("href",music_text[img_num-1].song);/*text()为改变文档，attr()改变属性，css()改变样式 */
            test_grade.text(music_text[img_num-1].testGrade);
            test_content.html(music_text[img_num-1].testContent);
            test_class.text(music_text[img_num-1].testClass);
            img_str="url(image/主页/bg"+img_num+".jpg)";
            /*body.css("background-image",img_str);*/
            singers.attr("href",music_text[img_num-1].singers);
            singers.text(music_text[img_num-1].testMusician);
        });
		btn_next.click(function(){
            if(img_num==5){
                img_num=1;
                
                a=1;
                b=5;
                
                temp0 = photoshow.eq(4);
                temp1 = photoshow.eq(img_num-1);
            }else{
                img_num=img_num+1;
                
                a=img_num;
                b=img_num-1;
                
                temp0 = photoshow.eq(img_num-2);
                temp1 = photoshow.eq(img_num-1);
            }
            
            //new.html
            photoshowInit(photoshow,a,b);
            temp0.stop().fadeTo(800,0,function(){
                temp0.css({
                "opacity":"0",
                "z-index":"7",
                "display":"none"
            });
            });
            temp1.stop().fadeTo(800,1,function(){
                temp1.css({
                    "z-index":"8",
                    "display":"block"
                });
            });
            
            test_name.text(music_text[img_num-1].testName);
            test_name.attr("href",music_text[img_num-1].song);
            test_grade.text(music_text[img_num-1].testGrade);
            test_content.html(music_text[img_num-1].testContent);
            test_class.text(music_text[img_num-1].testClass);
            img_str="url(image/主页/bg"+img_num+".jpg)";
            /*body.css("background-image",img_str);*/
            singers.attr("href",music_text[img_num-1].singers);
            singers.text(music_text[img_num-1].testMusician);
        });
	});	
function photoshowInit(photoshow,a,b){
    for (var index = photoshow.length; index > 0; index--) {
        if (index==a||index==b) {
            
        } else {
            var element = photoshow.eq(index-1);
            /*alert(element.attr("title"));*/
            /*element.fadeOut();*/
            
            //css()
            element.stop().css({
                "opacity":"0",
                "z-index":"7",
                "display":"none"
            });
            
            //animate()
            /*element.animate({
                "opacity":"0",
                "z-index":"7",
                "display":"none"
            },"slow");*/
            /*element.addClass("display_none"); */ //  
        }
              
    }
}
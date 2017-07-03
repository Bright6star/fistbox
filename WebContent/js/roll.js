$ (function(){
	
	
	
//	产品详情轮播
	jQuery(".picfocus").slide({ mainCell:".bd ul",effect:"left",autoPlay:true });
	
	
	
	
//	广告轮播
	jQuery(".slideBox").slide({mainCell:".bd ul",autoPlay:true});
	
		
		
//	主页产品轮播
	jQuery(".picScroll").slide({ mainCell:"ul", effect:"leftLoop", vis:3, scroll:1,  autoPage:true, switchLoad:"_src" });

		
	
	
})

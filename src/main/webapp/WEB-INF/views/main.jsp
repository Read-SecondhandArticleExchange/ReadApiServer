<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!--  This site was created in Webflow. http://www.webflow.com -->
<!--  Last Published: Sat Aug 12 2017 07:01:04 GMT+0000 (UTC)  -->
<html data-wf-page="59883d741c3cee0001f9180b"
	data-wf-site="59883d741c3cee0001f9180c">
<head>
<meta charset="utf-8">
<title>app-read</title>
<meta content="width=device-width, initial-scale=1" name="viewport">
<meta content="Webflow" name="generator">
<link
	href="${pageContext.request.contextPath}/resources/READ_W~1/css/normalize.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/resources/READ_W~1/css/webflow.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/resources/READ_W~1/css/app-readme.webflow.css"
	rel="stylesheet" type="text/css">
<style type="text/css">
.frame {
	/* 	height: 250px; */
	/* 	line-height: 250px; */
	overflow: hidden;
}

.frame .slidee {
	list-style: none;
	margin: 0;
	padding: 0;
	height: 100%;
}

.frame .slidee li {
	float: left;
	width: 200px;
	height: 100%;
	margin: 0 1px 0 0;
	padding: 0;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/webfont/1.4.7/webfont.js"
	type="text/javascript"></script>
<script type="text/javascript">
	WebFont
		.load({
			google : {
				families : [
					"Ubuntu:300,300italic,400,400italic,500,500italic,700,700italic",
					"Noto Sans:regular,italic,700,700italic:latin-ext,cyrillic-ext,vietnamese,latin",
					"Passion One:regular,700,900", "Baloo:regular",
					"Days One:regular", "Wire One:regular" ]
			}
		});
</script>
<!-- [if lt IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js" type="text/javascript"></script><![endif] -->
<script type="text/javascript">
	!function(o, c) {
		var n = c.documentElement,
			t = " w-mod-";
		n.className += t + "js", ("ontouchstart" in o || o.DocumentTouch
		&& c instanceof DocumentTouch)
		&& (n.className += t + "touch")
	}(window, document);
</script>
<link href="https://daks2k3a4ib2z.cloudfront.net/img/favicon.ico"
	rel="shortcut icon" type="image/x-icon">
<link href="https://daks2k3a4ib2z.cloudfront.net/img/webclip.png"
	rel="apple-touch-icon">
</head>
<body class="body">
	<div class="navbar w-nav" data-animation="default"
		data-collapse="medium" data-duration="400">
		<div class="container w-container">
			<a class="brand w-nav-brand" href="#">
				<div class="div-block-2">
					<img
						src="${pageContext.request.contextPath}/resources/READ_W~1/images/Logo.svg">
				</div>
			</a>
			<div class="navblock">
				<a class="button line mobile top w-button" data-ix="navsetting"
					href="#">Android App</a>
			</div>
		</div>
	</div>
	<div class="orange section" data-ix="navsetting">
		<div class="div horizontal">
			<div class="left maindiv">
				<div class="mainindiv top">
					<div>
						<img
							src="${pageContext.request.contextPath}/resources/READ_W~1/images/Logo.svg">
					</div>
				</div>
				<div class="mainindiv mid">
					<div class="maintext">좋은 책을, 좋은 사람에게.</div>
					<div class="_48px bold maintext">1:1 중고도서 교환 플랫폼</div>
					<div class="div-block-4">
						<a class="button line mobile w-button" href="#">Android App</a><a
							class="button line mobile w-button" href="#">iOS App</a>
					</div>
				</div>
				<div class="bottom mainindiv">
					<a class="button icon insta line w-button" href="#"></a><a
						class="button fb icon line w-button" href="#"></a><a
						class="button icon kko line w-button" href="#"></a>
				</div>
			</div>
			<div class="maindiv right">
				<div class="mainimage">
					<img class="image-2"
						src="${pageContext.request.contextPath}/resources/READ_W~1/images/web_prototype.png">
				</div>
			</div>
		</div>
	</div>
	<div class="grey section">
		<div class="count div">
			<div class="countcontents">
				<div class="countcontent top">
					<div class="counttext">누적 도서량</div>
				</div>
				<div class="countcontent mid">
					<div class="dot"></div>
				</div>
				<div class="bottom countcontent">
					<div class="counttext">
						<fmt:formatNumber value="${summary.accumulateBookCount }"
							pattern="#,###" />
					</div>
				</div>
			</div>
			<div class="countcontents">
				<div class="countcontent top">
					<div class="counttext">도서 종류</div>
				</div>
				<div class="countcontent mid">
					<div class="dot"></div>
				</div>
				<div class="bottom countcontent">
					<div class="counttext">
						<fmt:formatNumber value="${summary.kindOfBook }" pattern="#,###" />
					</div>
				</div>
			</div>
			<div class="countcontents">
				<div class="countcontent top">
					<div class="counttext">요청 가능한 책</div>
				</div>
				<div class="countcontent mid">
					<div class="dot"></div>
				</div>
				<div class="bottom countcontent">
					<div class="counttext">
						<fmt:formatNumber value="${summary.requestPossibleBook }"
							pattern="#,###" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="section white">
		<div class="div vertical">
			<div class="text-block">최근 올라온 책</div>
			<div style="overflow: hidden;">
				<div class="text-block-2"
					style="display: table-cell; vertical-align: middle;">
					<div class="frame" id="slide-frame">
						<ul class="slidee">
							<c:forEach items="${bookList}" var="book">
								<li style="text-align: center;">
									<div style="text-align: left;">
										<img src="${book.coverUrl }" width="190px">
										<div style="font-weight: bold;">${book.title }</div>
										<div>${book.author }</div>
										<div>${book.publisher }</div>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="gray1 section">
		<div class="div vertical">
			<div class="text-block">About</div>
			<div class="w-row">
				<div class="aboutcolumn left w-col w-col-4">
					<div class="aboutdiv">
						<img class="aboutimage"
							src="${pageContext.request.contextPath}/resources/READ_W~1/images/about-01.svg">
						<div class="abouttext">방치된 책들에 자유를!</div>
						<div class="stroke"></div>
						<div class="_16 text-block-3">내 방, 내 서재에 방치되어 있던 책들을 공유해 가치를
							부여해보세요. 내 책을 공유해 받은 가상도서로 새로운 책을 만날 수 있습니다!</div>
					</div>
				</div>
				<div class="aboutcolumn mid w-col w-col-4">
					<div class="aboutdiv">
						<img class="aboutimage"
							src="${pageContext.request.contextPath}/resources/READ_W~1/images/about-02.svg">
						<div class="abouttext">내 책이 어디에 있을까?</div>
						<div class="stroke"></div>
						<div class="_16 text-block-3">내가 올린 책, 나를 거쳐간 책이 지금 어디에 있는지
							궁금하지 않나요? 지금 리드에서 내 책의 위치를 실시간으로 알아보세요!</div>
					</div>
				</div>
				<div class="aboutcolumn right w-col w-col-4">
					<div class="aboutdiv">
						<img class="aboutimage"
							src="${pageContext.request.contextPath}/resources/READ_W~1/images/about-03.svg">
						<div class="abouttext">이 모든 것을 무료로!</div>
						<div class="stroke"></div>
						<div class="_16 text-block-3">리드 서비스는 착불 배송비를 제외한 일체의 비용이 들지
							않아요. 오직 책을 받을 때 착불 배송비만 부담하시면 됩니다!</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="section white">
		<div class="div vertical">
			<div class="text-block">Service</div>
			<div class="w-row">
				<div class="aboutcolumn left w-col w-col-4">
					<div class="aboutdiv">
						<img class="serviceimage"
							src="${pageContext.request.contextPath}/resources/READ_W~1/images/web_prototype2.png"
							width="250">
						<div class="service-text">북로그</div>
						<div class="_16 text-block-3">해당 유저가 리드 앱을 통해 어떤 책을 읽었는지 알 수
							있어요. 추후 커뮤니티 기능이 추가되면 북로그의 각 컨텐트는 하나의 채팅방이 됩니다.</div>
					</div>
				</div>
				<div class="aboutcolumn mid w-col w-col-4">
					<div class="aboutdiv">
						<img class="serviceimage"
							src="${pageContext.request.contextPath}/resources/READ_W~1/images/web_prototype.png"
							width="250">
						<div class="service-text">리드박스</div>
						<div class="_16 text-block-3">자신이 소유한 책을 업로드하고, 다른 사람과 공유할 수
							있는 가상 공간입니다. 책을 보내고 받는 등 책의 상태를 관리하는 핵심 기능이 있어요.</div>
					</div>
				</div>
				<div class="aboutcolumn right w-col w-col-4">
					<div class="aboutdiv">
						<img class="serviceimage"
							src="${pageContext.request.contextPath}/resources/READ_W~1/images/web_prototype3.png"
							width="250">
						<div class="service-text">도서요청</div>
						<div class="_16 text-block-3">가상도서를 이용하여 원하는 책을 요청하는 공간이에요.
							도서명, 저자, 출판사 등으로 검색이 가능하며 먼저 올라온 책이 먼저 매칭됩니다.</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="gray1 section">
		<div class="div vertical">
			<div class="text-block">Contact</div>
			<div class="row w-row">
				<div class="column w-col w-col-6 w-col-stack">
					<div class="image-3" id="map" style="height: 500px;"></div>
					<!-- 					<img class="image-3" src="https://d3e54v103j8qbb.cloudfront.net/img/image-placeholder.svg"> -->
					<div class="contact-buttons">
						<a class="button flat insta w-button" href="#"></a><a
							class="button fb flat w-button" href="#"></a><a
							class="button flat kko w-button" href="#"></a>
					</div>
				</div>
				<div class="w-col w-col-6 w-col-stack">
					<div class="contactdivin">
						<div class="row-2 w-row">
							<div
								class="contactinfo heading w-col w-col-3 w-col-small-3 w-col-tiny-3">
								<div class="address contacttext">Address</div>
								<div class="contacttext">Mobile</div>
								<div class="contacttext">E-mail</div>
								<div class="contacttext">Contact</div>
							</div>
							<div class="contactinfo w-col w-col-9 w-col-small-9 w-col-tiny-9">
								<div class="address contacttext">
									서울특별시 강남구 역삼동 671-29<br>28, Nonhyeon-ro 98-gil,
									Gangnam-gu, Seoul, Korea
								</div>
								<div class="contacttext">+82. 10. 4930. 2614</div>
								<div class="contacttext">ceo@app-read.me</div>
								<div class="w-form">
									<form class="form" data-name="Email Form" id="email-form"
										name="email-form">
										<input class="contacttextfield w-input" data-name="Name 2"
											id="name-2" maxlength="256" name="name-2"
											placeholder="Enter your name" type="text"><input
											class="contacttextfield w-input" data-name="Email 4"
											id="email-4" maxlength="256" name="email-4"
											placeholder="Enter your email" required="required"
											type="email"><input class="contacttextfield w-input"
											data-name="Email 3" id="email-3" maxlength="256"
											name="email-3" placeholder="Enter your Mobile"
											required="required" type="text">
										<textarea class="textarea w-input" data-name="Content 2"
											id="Content-2" maxlength="5000" name="Content-2"
											placeholder="Content"></textarea>
										<input class="submit-button w-button"
											data-wait="Please wait..." type="submit" value="Send">
									</form>
									<div class="w-form-done">
										<div>Thank you! Your submission has been received!</div>
									</div>
									<div class="w-form-fail">
										<div>Oops! Something went wrong while submitting the
											form.</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="w-embed">
		<style>
.xxx {
	background: rgba(0, 0, 0, 0.05);
}
</style>
	</div>
	<div class="footer">
		<div class="div footer vertical">
			<img class="footer-logo"
				src="${pageContext.request.contextPath}/resources/READ_W~1/images/Logo.svg">
			<div class="div footer horizontal">
				<div class="footerwhite">
					<p class="paragraph">
						리드<br>대표이사: 윤이건<br>서울특별시 강남구 역삼동 상세주소<br>전화 :
						010-4930-2614
					</p>
				</div>
				<div class="footerwhite">
					<p class="paragraph">
						이메일 : ceo@app-read.me<br>사업자등록번호 : 851-26-00524<br>통신판매업신고번호제2011-서울마포-1010호
					</p>
				</div>
			</div>
			<div class="div footer horizontal">
				<div class="footerdiv">
					<p class="paragraph">Copyright © READ&nbsp;All rights reserved.</p>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/resources/READ_W~1/js/webflow.js"
		type="text/javascript"></script>
	<script src="//code.jquery.com/jquery.min.js"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/READ_W~1/js/sly.min.js"
		type="text/javascript"></script>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3ae20d3951481d51b7d198002e5cfaa3"></script>
	<script type="text/javascript">
		var options = {
			horizontal : 1,
			itemNav : 'basic',
			smart : 1,
			activateOn : 'click',
			mouseDragging : 1,
			touchDragging : 1,
			releaseSwing : 1,
			startAt : 0,
			activatePageOn : 'click',
			speed : 300,
			elasticBounds : 1,
			easing : 'easeOutExpo',
			dragHandle : 1,
			dynamicHandle : 1,
	
			cycleBy : 'pages',
			cycleInterval : 3000,
			pauseOnHover : 1
		};
		var sly = new Sly('#slide-frame', options).init();
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center : new daum.maps.LatLng(37.504074, 127.038064), //지도의 중심좌표.
			level : 4 //지도의 레벨(확대, 축소 정도)
		};
		var map = new daum.maps.Map(container, options); //지도 생성 및 객체 리턴
		// 마커가 표시될 위치입니다 
		var markerPosition = new daum.maps.LatLng(37.504074, 127.038064);
		// 마커를 생성합니다
		var marker = new daum.maps.Marker({
			position : markerPosition
		});
		// 마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);
	</script>
	<!-- [if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif] -->
</body>
</html>
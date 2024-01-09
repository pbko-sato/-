<%@ page pageEncoding="UTF-8" %>
<header class="header">
	<h1 class="header-title"><a class="header-link" href="/GoogleMap/pages/Top/Top.jsp">社内食べログ</a></h1>
	<nav class="nav">
		<div class="display-id-and-name">
			${loginInfo.getId()}. ${loginInfo.getName()}さん
		</div>
		<ul class="header-ul">
			<li class="header-li"><a class="header-link" href="/GoogleMap/HeaderServlet?action=TransitToMyPage">マイページ</a></li>
			<li class="header-li"><a class="header-link" href="">お店を探す</a></li>
			<li class="header-li"><a class="header-link" href="">お店をシェアする</a></li>
			<li class="header-li"><a class="header-link" href="/GoogleMap/HeaderServlet?action=Logout">ログアウト</a></li>
		</ul>
	</nav>
</header>
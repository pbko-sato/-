<%@ page pageEncoding="UTF-8" %>
<header>
	<h1><a href="/GoogleMap/pages/Top/Top.jsp">社内食べログ</a></h1>
	<nav>
		<div class="display-id-and-name">
			${loginInfo.getId()}. ${loginInfo.getName()}さん
		</div>
		<ul>
			<li><a href="">マイページ</a></li>
			<li><a href="">お店を探す</a></li>
			<li><a href="">お店をシェアする</a></li>
			<li><a href="/GoogleMap/LoginServlet?action=Logout">ログアウト</a></li>
		</ul>
	</nav>
</header>
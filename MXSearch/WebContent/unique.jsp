<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.recipe.domain.Recipe" %>
<!DOCTYPE html>
<html>
<head>
<%
	Recipe recipe = (Recipe)application.getAttribute("r") ;
	String key = (String)application.getAttribute("keyword") ;
%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%= recipe.getTitle() %></title>
</head>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Loading Bootstrap -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="bootstrap/css/prettify.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="css/flat-ui.css" rel="stylesheet">
    <link href="css/docs.css" rel="stylesheet">

    <link rel="shortcut icon" href="images/favicon.ico">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
</head>
<body style="width:1200px;margin:0 auto;">
<nav class="navbar navbar-default" role="navigation">
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-01">
      <span class="sr-only">Toggle navigation</span>
    </button>
    <a class="navbar-brand" href="/MXSearch">麦香食谱</a>
  </div>
  <div class="collapse navbar-collapse" id="navbar-collapse-01">
    <ul class="nav navbar-nav">           
      <li class="active"><a href="/MXSearch/index.jsp">Products</a></li>
      <li><a href="/MXSearch/feature.jsp">Features</a></li>
    </ul>           
    <form class="navbar-form navbar-left" method="get" action="/MXSearch/unique" role="search">
      <div class="form-group">
        <div class="input-group">
          <input class="form-control" name="keyword" id="navbarInput-01" type="search" placeholder="Search">
          <span class="input-group-btn">
            <button type="submit" class="btn"><span class="fui-search"></span></button>
          </span>            
        </div>
      </div>               
    </form>
  </div><!-- /.navbar-collapse -->
</nav><!-- /navbar -->


<body>
<p class="text-right" data-toggle="tooltip" title="<%= recipe.getTitle() %>不是你想要的？点击查看其他相关食谱">
<a href="/MXSearch/search?keyword=<%=application.getAttribute("keyword")%>">
查看其他相关食谱
</a>
</p>
<hr/>
<h3>推荐食谱</h3>
<div class="container">
<pre>
<h3><%= recipe.getTitle() %>            	<img src="<%= recipe.getImageUrl() %>" height="305" width="252"/>
</h3>
</pre>
<hr/>
<pre>
<p>口味： <small><%= recipe.getTaste() %> </small>              	 所需时间： <small><%= recipe.getTime() %></small>				难度：<small><%= recipe.getDifficulty() %></small></p>
</pre>
<b>简介</b>
<blockquote>
<p><%= recipe.getDesp() %></p>
</blockquote>
<p><%= recipe.getMaterials() %></p>
<p><%= recipe.getMethod() %></p>
<hr/>
<p>引用处：<a href="<%= recipe.getUrl()%>"><%= recipe.getUrl() %></a></p>
<hr/>
</div>
    <!-- Load JS here for greater good =============================-->
    <script src="js/jquery-1.8.3.min.js"></script>
    <script src="js/jquery-ui-1.10.3.custom.min.js"></script>
    <script src="js/jquery.ui.touch-punch.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrap-select.js"></script>
    <script src="js/bootstrap-switch.js"></script>
    <script src="js/flatui-checkbox.js"></script>
    <script src="js/flatui-radio.js"></script>
    <script src="js/jquery.tagsinput.js"></script>
    <script src="js/jquery.placeholder.js"></script>
    <script src="js/typeahead.js"></script>
    <script src="bootstrap/js/google-code-prettify/prettify.js"></script>
    <script src="js/application.js"></script>
</body>
</html>
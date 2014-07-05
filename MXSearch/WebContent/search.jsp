<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食谱搜索页</title>

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
    <form class="navbar-form navbar-left" action="/MXSearch/unique" role="search" method="get">
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

 
<h4>食谱搜索页面</h4>
<hr/>

<div class="container" class="margin:0 auto;">
<form class="form-inline" action="/MXSearch/unique" role="form" method="get">
  <div class="form-group">
    <label class="sr-only" for="exampleInputEmail2">search</label>
    <input type="text" class="form-control input-lg" name="keyword" id="exampleInputEmail2" placeholder="请输入关键词">
  </div>
  <button type="submit" class="btn btn-default btn-lg">搜索食谱</button>
</form>
</div>
<br/><br/>
 <div class="container">
 <p class="text-danger">不知道搜什么？请点击我们推出的特色搜索服务</p>
 <a href="/MXSearch/feature.jsp">
<button class="btn btn-hg btn-primary">
  特色搜索
</button>
</a>    
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
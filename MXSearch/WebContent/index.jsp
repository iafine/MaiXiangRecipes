<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>麦香食谱库-- 这是一本神奇的食谱</title>

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
    <form class="navbar-form navbar-left" action="/MXSearch/unique" role="search">
      <div class="form-group">
        <div class="input-group">
          <input class="form-control" id="navbarInput-01" name="keyword" type="search" placeholder="Search">
          <span class="input-group-btn">
            <button type="submit" class="btn"><span class="fui-search"></span></button>
          </span>            
        </div>
      </div>               
    </form>
  </div><!-- /.navbar-collapse -->
</nav><!-- /navbar -->
<div class="container">
<h1>麦香食谱库</h1>
<blockquote>
<p class="text-muted">麦香食谱库是一个关于中国饮食文化的知识库，目前已经收录了2000多条食谱，正在努力的建设中...</p>
</blockquote>
<a href="/MXSearch/search.jsp">
<button class="btn btn-hg btn-primary" >
  搜索食谱
</button>
</a>    
</div>
<hr/>
<div class="container">
<h3>菜谱特点:</h3>
<p>
	<ul>
	<li class="text-muted">1. 菜谱采集于互联网，免费提供给大家</li>
	<li class="text-muted">2. 在每一个菜谱中，我们有详细的步骤和做法</li>
	<li class="text-muted">3. 为了适应快节奏，我们提供了花费时间，口味，难度等细节</li>
	</ul>
</p>
<a href="/MXSearch/tastes">
<button class="btn btn-hg btn-primary">
  查看所有食谱
</button>    
</a>
</div>
<br/>
<hr/>
    <footer>
      <div class="container">
        <div class="row">
          <div class="col-xs-7">
            <h3 class="footer-title">食谱知识库</h3>
            <p>这里是本站所有的食谱，欢迎志同道合的人来未中国饮食文化作出一点贡献...</p>
            					<h4 class="footer-title">注意事项</h4>
            <p>
            						本站点所有食谱均来自于<b class="text-info">互联网</b>，所有数据只是<b class="text-info">学习测试</b>所用。<br/>如有侵犯，请多多见谅...
            </p>
             </div> <!-- /col-xs-7 -->

      <div class="col-xs-5">
        <div class="footer-banner">
          <h3 class="footer-title">关于食谱的小解释</h3>
          <ul>
            <li></li>
            <li>所有食谱采集与互联网，若有侵权请多多谅解</li>
            <li>若由于食谱出错所带来的健康危害，与本站无关</li>
            <li>食谱中若有错误，请与本站负责人联系</li>
            <li>如果需要数据或者本站的技术实现，请参考博客</li>
          </ul>
          Blog: <a href="http://hyyy.info" target="_blank">hyyy.info</a>
        </div>
      </div>
    </div>
  </div>
</footer>
<hr/>
 
 
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
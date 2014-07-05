<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>特色搜索服务 </title>

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
<br/>
<blockquote>
<p class="text-success">当面对太多的美食时，您是否觉得无从下手？</p>
<p class="text-success">每到饭点时，别人问你吃什么，是否总是说随便？</p>
<p>如果是的话，快来看看我们推出的智能搜索，您只要选择一些无关紧要的选项，我们就可以为您推出合适的食谱</p>
</blockquote>
<hr/>
<h4>智能推荐食谱</h4>
<div class="container" class="margin:0 auto;">

<form class="form-horizontal" action="/MXSearch/feature" role="form">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">您是一个什么样的人</label>
    <div class="col-sm-6">
      <select class="form-control" name="taste">
				  <option value="甜">热情开朗，平易近人</option>
				  <option value="辣">善于思考，有主见</option>
				  <option value="咸">待人接物稳重，做事有计划</option>
				  <option value="酸">性格孤僻，不善交际</option>
				</select>
				<span class="help-block">
				请选择一个你认为最接近你的选项
				</span>
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">您忙吗？</label>
    <div class="col-sm-6">
      <select class="form-control" name="time">
				  <option value="<10分钟">忙</option>
				  <option value="<30分钟">不忙</option>
				  <option value="<15分钟">有点忙</option>
				</select>
				<span class="help-block">
				请选择一个目前最接近你状况的选项
				</span>
    </div>
  </div>
    <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">饮食在你心中的地位？</label>
    <div class="col-sm-6">
      <select class="form-control" name="diff">
				  <option value="初中水平">饮食居其首</option>
				  <option value="初级入门">业余玩玩</option>
				  <option value="新手尝试">完全不在乎</option>
				</select>
				<span class="help-block">
				请选择一个最接近你内心的选项
				</span>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">开始智能搜索</button>
    </div>
  </div>
</form>
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
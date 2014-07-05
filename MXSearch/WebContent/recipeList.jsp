<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
    import = "java.util.*" 
    import = "org.recipe.domain.Recipe"
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>全部食谱列表</title>
			
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
          <input class="form-control" id="navbarInput-01" name="keyword" type="search" placeholder="Search">
          <span class="input-group-btn">
            <button type="submit" class="btn"><span class="fui-search"></span></button>
          </span>            
        </div>
      </div>               
    </form>
  </div><!-- /.navbar-collapse -->
</nav><!-- /navbar -->

<blockquote>
<h4>食谱口味排名</h4>
<p>由下面的口味排名可以看出，大多数人喜欢的口味是<b class="text-info">咸鲜味</b>和<b class="text-info">甜味</b>，难道就没人喜欢酸辣吗...</p>
</blockquote>
<table class="table table-hover" style="width:1000px;">
  <thead>
    <tr>
      <th>编号</th>
      <th>食谱口味</th>
      <th>统计数</th>
    </tr>
  </thead>
  <tbody>
<% 
	TreeMap<String, Integer> taste = (TreeMap<String, Integer>)application.getAttribute("taste") ;
	System.out.println(taste.size()) ;
	  
 Iterator iterator = taste.entrySet().iterator();
 int i = 1 ;
    while(iterator.hasNext()){  
        Map.Entry ent=(Map.Entry )iterator.next();  
        String key=ent.getKey().toString();  
        String value=ent.getValue().toString();  
%>
    <tr>
      <td><%= i%></td>
      <td><%= key%></td>
      <td><%= value%></td>
    </tr>        
 <% 
 					i++ ;
      	System.out.println(key+"*"+value);  
    }
%>
  </tbody>
</table>
<hr/>
<blockquote>
<h4>食谱所需时间排名</h4>
<p>从下面的表格可以看出，大多数食谱所需时间在<b class="text-info">10分钟</b>到<b class="text-info">30分钟</b>之间，给我一点时间，我也可以成为大厨...</p>
</blockquote>
<table class="table table-hover" style="width:1000px;">
  <thead>
    <tr>
      <th>编号</th>
      <th>食谱所花时间</th>
      <th>统计数</th>
    </tr>
  </thead>
  <tbody>
<% 
	TreeMap<String, Integer> time = (TreeMap<String, Integer>)application.getAttribute("time") ;
	Iterator iter = time.entrySet().iterator();
	int j = 1 ;
	
   while(iter.hasNext()){  
       Map.Entry ent=(Map.Entry )iter.next();  
       String key=ent.getKey().toString();  
       String value=ent.getValue().toString();  
%>
   <tr>
     <td><%= j%></td>
     <td><%= key%></td>
     <td><%= value%></td>
   </tr>        
<% 
				j++ ;
     	System.out.println(key+"*"+value);  
   }
%>
  </tbody>
</table>
<hr/>
<blockquote>
<h4>食谱难度排名</h4>
<p>从下面的表格可以看出，大多数食谱的难度在<b class="text-info">初中水平</b>，貌似做菜也没那么难...</p>
</blockquote>
<table class="table table-hover" style="width:1000px;">
  <thead>
    <tr>
      <th>编号</th>
      <th>食谱难度</th>
      <th>统计数</th>
    </tr>
  </thead>
  <tbody>
<% 
	TreeMap<String, Integer> diff = (TreeMap<String, Integer>)application.getAttribute("diff") ;
	Iterator it = diff.entrySet().iterator();
	int k = 1 ;
	
   while(it.hasNext()){  
       Map.Entry ent=(Map.Entry )it.next();  
       String key=ent.getKey().toString();  
       String value=ent.getValue().toString();  
%>
   <tr>
     <td><%= k%></td>
     <td><%= key%></td>
     <td><%= value%></td>
   </tr>        
<% 
				k++ ;
     	System.out.println(key+"*"+value);  
   }
%>
  </tbody>
</table>

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
    <script src="js/Chart.js"></script>
</body>
</html>
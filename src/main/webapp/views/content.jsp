<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Đọc truyện Online</title>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>

<body style="padding-top: 86px;">

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="#">ĐỌC TRUYỆN ONLINE</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Conan
              <span class="sr-only">(current)</span>
            </a>
          </li>
          
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <div class="col-lg-12">

        <div class="row" id="all-book">

        </div>
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Your Website 2020</p>
    </div>
    <!-- /.container -->
  </footer>

	<script type="text/javascript">
	
	$(document).ready(function(){
		$.ajax({
		    url: '/crawl-data/books',
		    type: "get",
		    dataType: "json",
				 complete: function(xhr, textStatus) {
				if(xhr.status == 404) {
					alert('Khong tim thay');
				}
			}
		}).done(function(res) {
			var size = res.length;
			for(var i = 0; i < size; i++) {
				var content = "<div class='col-lg-2 col-md-3 col-sm-6 mb-4'>" + 
									"<div class='card h-100'>" +
										"<a href='#'><img class='card-img-top' src='"+ res[i].urlImg +"'></a>"+
										"<div class='card-body'>" + 
											"<h6 class='card-title'>" +
							                  "<a href='#'>"+ res[i].title +"</a>" +
							                  "</h6>" +
										"</div>" +
									"</div" +
							   "</div";
				
				
				$("#all-book").append(content);
			}
		});

		  
		});
		
	
	</script>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>API DOC - Comic CONAN</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" href="https://www.seekpng.com/png/full/527-5275313_app-icon-detective-conan-avatar.png">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style type="text/css">
	code {
		font-size: 16px;
	}
	.sub-header {font-weight: bold; padding: 8pt; border-bottom: 1px solid #48484a;}
	.api {
		display: flex;
	    align-items: center;
	    justify-content: space-between;
	    width: 100%;
	    padding: 8pt;
	    background-color: #F2F2F2;
	    border-radius: 4pt;
	}
	.tools {
		flex-basis: 15%;
	    align-items: center;
	    max-width: 65px;
	    display: flex;
	    justify-content: flex-end;
	}

	.tooltip-btn {
		position: relative;
	    text-align: center;
	    border: none;
	    background-color: transparent;
	    border-radius: 6pt;
	    max-width: 24pt;
	    padding: 4pt;
	}
	.tooltip-docs {
		display: none;
	    position: absolute;
	    left: 50%;
	    top: -35px;
	    margin-left: -24px;
	    padding: 2pt;
	    border-radius: 4pt;
	    background-color: #ffffff;
	    border: 1px solid #ececed;
	    width: 48px;
	    font-family: "Space Grotesk", Arial, sans-serif;
	    font-size: 14px;
	    text-align: center;
	}

	.tooltip-btn:hover{
		background-color: #DCDCE3;
	}

	.tooltip-btn:hover .tooltip-docs{
		display: block;
	}

	.fa-copy {
		font-size: 20px;
	}

	.fa-sort-down {
		font-size: 25px;
	}

	.fa-sort-up {
		font-size: 25px;
	}

	.content {

		display: none;
	    border: none;
	    position: relative;
	    font-family: inherit;
	    font-size: inherit;
	    padding: 0 8pt;
	    width: 100%;
	    border: 1px solid #F2F2F2;
	}

	.content .tooltip-btn {
		position: absolute;
		top: 8pt;
		right: 8pt;
	}

	.content code {
		font-size: 12px;
	}

	.response {
		border-radius: 4pt;
	    margin-bottom: 16pt;
	    font-family: monospace;
	    width: 100%;
	    word-wrap: break-word;
	    border: 1px solid #F2F2F2;
	}

	.response.open .content{
		transition: all 1s linear;
		display: block;
	}


</style>

</head>
<body>
	<div class="container mt-3">
		<div id="information">
			<h2 class="text-info">Comic CONAN API</h2>
			<p class="ml-3">We collect and process data from a variety of sources. Currently the comic has about 98 volumes, 1067 chapters and many pages. We will update as soon as more data becomes available. Data is available in JSON or XML format.</p>
		</div>
		<div id="content">
			<!-- I -->
			<div class="paragraph">
				<h3 class="text-info mb-3">Get data book</h3>

				<!-- 1 -->
				<div class="paragraph ml-4">
				<h4 class="text-info">All books</h4>
					<div class="json">
						<h5 class="ml-5">JSON</h5>
						<p class="sub-header">API call</p>
						<div class="api">
							<code>api-comic-conan.herokuapp.com/books.json</code>
							<div class="tools">
								<button class="tooltip-btn btn-copy">
									<div class="tooltip-docs">Copy</div>
									<i class="fa fa-copy"></i>
								</button>
							</div>
						</div>
						<p class="sub-header">Examples of API calls:</p>
							<div class="response">
								<div class="api">
									<code>api-comic-conan.herokuapp.com/books.json</code>
									<div class="tools">
										<button class="tooltip-btn btn-res">
											<div class="tooltip-docs">Result</div>
											<i class="fa fa-sort-down"></i>
										</button>
										<button class="tooltip-btn btn-copy">
											<div class="tooltip-docs">Copy</div>
											<i class="fa fa-copy"></i>
										</button>
									</div>

								</div>
								<div class="content">
									<pre>
										<code>
[
		  {
		        "id": 1,
		        "title": "Thám tử lừng danh Conan - Tập 1",
		        "urlImg": "https://nxbkimdong.com.vn/sites/default/files/styles/uc_product/public/1_83.jpg?itok=q_QDAJHf",
		        "actor": "Gosho Aoyama",
		        "numPage": 184,
		        "releaseDate": "09/03/2020"
		  },
		  {
		        "id": 2,
		        "title": "Thám tử lừng danh Conan - Tập 2",
		        "urlImg": "https://nxbkimdong.com.vn/sites/default/files/styles/uc_product/public/2_202.jpg?itok=AdE3XBte",
		        "actor": "Gosho Aoyama",
		        "numPage": 176,
		        "releaseDate": "01/05/2020"
		  },
		  {
		      "id": 3,
		      "title": "Thám tử lừng danh Conan - Tập 3",
		      "urlImg": "https://nxbkimdong.com.vn/sites/default/fil/styles/uc_product/public/3_173.jpg?itok=6Au0LvLI",
		      "actor": "Gosho Aoyama",
		      				<h4>...</h4>
]
										</code>
									</pre>
									<div class="tools">
										<button class="tooltip-btn btn-copy">
											<div class="tooltip-docs">Copy</div>
											<i class="fa fa-copy"></i>
										</button>
									</div>
								</div>
							</div>
					</div>
					<div class="xml">
						<h5 class="ml-5">XML</h5>
						<p class="sub-header">API call</p>
						<div class="api">
							<code>api-comic-conan.herokuapp.com/books.xml</code>
							<div class="tools">
								<button class="tooltip-btn btn-copy">
									<div class="tooltip-docs">Copy</div>
									<i class="fa fa-copy"></i>
								</button>
							</div>
						</div>
						<p class="sub-header">Examples of API calls:</p>
							<div class="response">
								<div class="api">
									<code>api-comic-conan.herokuapp.com/books.xml</code>
									<div class="tools">
										<button class="tooltip-btn btn-res">
											<div class="tooltip-docs">Result</div>
											<i class="fa fa-sort-down"></i>
										</button>
										<button class="tooltip-btn btn-copy">
											<div class="tooltip-docs">Copy</div>
											<i class="fa fa-copy"></i>
										</button>
									</div>

								</div>
								<div class="content">
									<pre lang="xml">
										<code>
&lt;List&gt;
	&lt;item&gt;
	        &lt;id&gt;1&lt;/id&gt;
	        &lt;title&gt;Thám tử lừng danh Conan - Tập 1&lt;/title&gt;
	        &lt;urlImg&gt;https://nxbkimdong.com.vn/sites/default/files/styles/uc_product/public/1_83.jpg?itok=q_QDAJHf&lt;/urlImg&gt;
	        &lt;actor&gt;Gosho Aoyama&lt;/actor&gt;
	        &lt;numPage&gt;184&lt;/numPage&gt;
	        &lt;releaseDate&gt;09/03/2020&lt;/releaseDate&gt;
	&lt;/item&gt;
	&lt;item&gt;
	    &lt;id&gt;2&lt;/id&gt;
	    &lt;title&gt;Thám tử lừng danh Conan - Tập 2&lt;/title&gt;
	    &lt;urlImg&gt;https://nxbkimdong.com.vn/sites/default/files/styles/uc_product/public/2_202.jpg?itok=AdE3XBte&lt;/ur	gt;
	    &lt;actor&gt;Gosho Aoyama&lt;/actor&gt;
	    &lt;numPage&gt;176&lt;/numPage&gt;
	    					<h4>...</h4>
&lt;/List&gt;   		
										</code>
									</pre>
									<div class="tools">
										<button class="tooltip-btn btn-copy">
											<div class="tooltip-docs">Copy</div>
											<i class="fa fa-copy"></i>
										</button>
									</div>
								</div>
							</div>
					</div>
					<!-- end - 1 -->

					<!-- 2 -->
				<div class="paragraph">
				<h4 class="text-info ml-3">One book by Id</h4>
					<div class="json">
						<h5 class="ml-5">JSON</h5>
						<p class="sub-header">API call</p>
						<div class="api">
							<code>api-comic-conan.herokuapp.com/book/{id}.json</code>
							<div class="tools">
								<button class="tooltip-btn btn-copy">
									<div class="tooltip-docs">Copy</div>
									<i class="fa fa-copy"></i>
								</button>
							</div>
						</div>
						<p class="sub-header">Examples of API calls:</p>
							<div class="response">
								<div class="api">
									<code>api-comic-conan.herokuapp.com/book/3.json</code>
									<div class="tools">
										<button class="tooltip-btn btn-res">
											<div class="tooltip-docs">Result</div>
											<i class="fa fa-sort-down"></i>
										</button>
										<button class="tooltip-btn btn-copy">
											<div class="tooltip-docs">Copy</div>
											<i class="fa fa-copy"></i>
										</button>
									</div>

								</div>
								<div class="content">
									<pre>
										<code>
{
    "id": 3,
    "title": "Thám tử lừng danh Conan - Tập 3",
    "urlImg": "https://nxbkimdong.com.vn/sites/default/files/styles/uc_product/public/3_173.jpg?itok=6Au0LvLI",
    "actor": "Gosho Aoyama",
    "numPage": 176,
    "releaseDate": "01/05/2020"
}
										</code>
									</pre>
									<div class="tools">
										<button class="tooltip-btn btn-copy">
											<div class="tooltip-docs">Copy</div>
											<i class="fa fa-copy"></i>
										</button>
									</div>
								</div>
							</div>
					</div>
					<div class="xml">
						<h5 class="ml-5">XML</h5>
						<p class="sub-header">API call</p>
						<div class="api">
							<code>api-comic-conan.herokuapp.com/book/{id}.xml</code>
							<div class="tools">
								<button class="tooltip-btn btn-copy">
									<div class="tooltip-docs">Copy</div>
									<i class="fa fa-copy"></i>
								</button>
							</div>
						</div>
						<p class="sub-header">Examples of API calls:</p>
							<div class="response">
								<div class="api">
									<code>api-comic-conan.herokuapp.com/book/3.xml</code>
									<div class="tools">
										<button class="tooltip-btn btn-res">
											<div class="tooltip-docs">Result</div>
											<i class="fa fa-sort-down"></i>
										</button>
										<button class="tooltip-btn btn-copy">
											<div class="tooltip-docs">Copy</div>
											<i class="fa fa-copy"></i>
										</button>
									</div>

								</div>
								<div class="content">
									<pre>
										<code>
&lt;Book&gt;
    &lt;id&gt;3&lt;/id&gt;
    &lt;title&gt;Thám tử lừng danh Conan - Tập 3&lt;/title&gt;
    &lt;urlImg&gt;https://nxbkimdong.com.vn/sites/default/files/styles/uc_product/public/3_173.jpg?itok=6Au0LvLI&lt;/urlImg&gt;
    &lt;actor&gt;Gosho Aoyama&lt;/actor&gt;
    &lt;numPage&gt;176&lt;/numPage&gt;
    &lt;releaseDate&gt;01/05/2020&lt;/releaseDate&gt;
&lt;/Book&gt;
										</code>
									</pre>
									<div class="tools">
										<button class="tooltip-btn btn-copy">
											<div class="tooltip-docs">Copy</div>
											<i class="fa fa-copy"></i>
										</button>
									</div>
								</div>
							</div>
					</div>
					<!-- end - 2 -->
				</div>
			</div>
			<!-- end - I -->

<!-- II -->
			<div class="paragraph">
				<h3 class="text-info mb-3">Get data chapter</h3>

				<!-- 1 -->
				<div class="paragraph ml-4">
				<h4 class="text-info">All chapters</h4>
					<div class="json">
						<h5 class="ml-5">JSON</h5>
						<p class="sub-header">API call</p>
						<div class="api">
							<code>api-comic-conan.herokuapp.com/chaps.json</code>
							<div class="tools">
								<button class="tooltip-btn btn-copy">
									<div class="tooltip-docs">Copy</div>
									<i class="fa fa-copy"></i>
								</button>
							</div>
						</div>
						<p class="sub-header">Examples of API calls:</p>
							<div class="response">
								<div class="api">
									<code>api-comic-conan.herokuapp.com/chaps.json</code>
									<div class="tools">
										<button class="tooltip-btn btn-res">
											<div class="tooltip-docs">Result</div>
											<i class="fa fa-sort-down"></i>
										</button>
										<button class="tooltip-btn btn-copy">
											<div class="tooltip-docs">Copy</div>
											<i class="fa fa-copy"></i>
										</button>
									</div>

								</div>
								<div class="content">
									<pre>
										<code>
[
    {
        "id": 0,
        "idBook": 1,
        "title": "Chap 1: Sherlock Holmes Nhật Bản",
        "alias": "chap-1",
        "urlChap": "https://truyenonline.info/conan/tap-1-sherlock-holmes-nhat-ban"
    },
    {
        "id": 0,
        "idBook": 1,
        "title": "Chap 2: THÁM TỬ TEO NHỎ",
        "alias": "chap-2",
        "urlChap": "https://truyenonline.info/conan/tap-2-tham-tu-teo-nho"
    },
    {
        "id": 0,
        "idBook": 1,
        "title": "Chap 3: THÁM TỬ BỊ CÔ LẬP",
		      				<h4>...</h4>
]
										</code>
									</pre>
									<div class="tools">
										<button class="tooltip-btn btn-copy">
											<div class="tooltip-docs">Copy</div>
											<i class="fa fa-copy"></i>
										</button>
									</div>
								</div>
							</div>
					</div>
					<div class="xml">
						<h5 class="ml-5">XML</h5>
						<p class="sub-header">API call</p>
						<div class="api">
							<code>api-comic-conan.herokuapp.com/chaps.xml</code>
							<div class="tools">
								<button class="tooltip-btn btn-copy">
									<div class="tooltip-docs">Copy</div>
									<i class="fa fa-copy"></i>
								</button>
							</div>
						</div>
						<p class="sub-header">Examples of API calls:</p>
							<div class="response">
								<div class="api">
									<code>api-comic-conan.herokuapp.com/chaps.xml</code>
									<div class="tools">
										<button class="tooltip-btn btn-res">
											<div class="tooltip-docs">Result</div>
											<i class="fa fa-sort-down"></i>
										</button>
										<button class="tooltip-btn btn-copy">
											<div class="tooltip-docs">Copy</div>
											<i class="fa fa-copy"></i>
										</button>
									</div>

								</div>
								<div class="content">
									<pre lang="xml">
										<code>
&lt;List&gt;
    &lt;item&gt;
        &lt;id&gt;0&lt;/id&gt;
        &lt;idBook&gt;1&lt;/idBook&gt;
        &lt;title&gt;Chap 1: Sherlock Holmes Nhật Bản&lt;/title&gt;
        &lt;alias&gt;chap-1&lt;/alias&gt;
        &lt;urlChap&gt;https://truyenonline.info/conan/tap-1-sherlock-holmes-nhat-ban&lt;/urlChap&gt;
    &lt;/item&gt;
    &lt;item&gt;
        &lt;id&gt;0&lt;/id&gt;
        &lt;idBook&gt;1&lt;/idBook&gt;
        &lt;title&gt;Chap 2: THÁM TỬ TEO NHỎ&lt;/title&gt;
        &lt;alias&gt;chap-2&lt;/alias&gt;
        &lt;urlChap&gt;https://truyenonline.info/conan/tap-2-tham-tu-teo-nho&lt;/urlChap&gt;
    &lt;/item&gt;
    &lt;item&gt;
        &lt;id&gt;0&lt;/id&gt;
        &lt;idBook&gt;1&lt;/idBook&gt;
        &lt;title&gt;Chap 3: THÁM TỬ BỊ CÔ LẬP&lt;/title&gt;
	    					<h4>...</h4>
&lt;/List&gt;   		
										</code>
									</pre>
									<div class="tools">
										<button class="tooltip-btn btn-copy">
											<div class="tooltip-docs">Copy</div>
											<i class="fa fa-copy"></i>
										</button>
									</div>
								</div>
							</div>
					</div>
					<!-- end - 1 -->

					<!-- 2 -->
				<div class="paragraph">
				<h4 class="text-info ml-3">All chapters by book Id</h4>
					<div class="json">
						<h5 class="ml-5">JSON</h5>
						<p class="sub-header">API call</p>
						<div class="api">
							<code>api-comic-conan.herokuapp.com/book/{id}/chaps.json</code>
							<div class="tools">
								<button class="tooltip-btn btn-copy">
									<div class="tooltip-docs">Copy</div>
									<i class="fa fa-copy"></i>
								</button>
							</div>
						</div>
						<p class="sub-header">Examples of API calls:</p>
							<div class="response">
								<div class="api">
									<code>api-comic-conan.herokuapp.com/book/3/chaps.json</code>
									<div class="tools">
										<button class="tooltip-btn btn-res">
											<div class="tooltip-docs">Result</div>
											<i class="fa fa-sort-down"></i>
										</button>
										<button class="tooltip-btn btn-copy">
											<div class="tooltip-docs">Copy</div>
											<i class="fa fa-copy"></i>
										</button>
									</div>

								</div>
								<div class="content">
									<pre>
										<code>
[
    {
        "id": 0,
        "idBook": 3,
        "title": "Chap 21: BÍ MẬT TRONG CĂN PHÒNG KÍN",
        "alias": "chap-21",
        "urlChap": "https://truyenonline.info/conan/tap-21-bi-mat-trong-can-phong-kin"
    },
    {
        "id": 0,
        "idBook": 3,
        "title": "Chap 22: QUYỀN THỪA KẾ",
        "alias": "chap-22",
        "urlChap": "https://truyenonline.info/conan/tap-22-quyen-thua-ke"
    },
    {
        "id": 0,
        "idBook": 3,
        "title": "Chap 23: BI KỊCH GIA ĐÌNH",
        		<h4>...</h4>
]
										</code>
									</pre>
									<div class="tools">
										<button class="tooltip-btn btn-copy">
											<div class="tooltip-docs">Copy</div>
											<i class="fa fa-copy"></i>
										</button>
									</div>
								</div>
							</div>
					</div>
					<div class="xml">
						<h5 class="ml-5">XML</h5>
						<p class="sub-header">API call</p>
						<div class="api">
							<code>api-comic-conan.herokuapp.com/book/{id}/chaps.xml</code>
							<div class="tools">
								<button class="tooltip-btn btn-copy">
									<div class="tooltip-docs">Copy</div>
									<i class="fa fa-copy"></i>
								</button>
							</div>
						</div>
						<p class="sub-header">Examples of API calls:</p>
							<div class="response">
								<div class="api">
									<code>api-comic-conan.herokuapp.com/book/3/chaps.xml</code>
									<div class="tools">
										<button class="tooltip-btn btn-res">
											<div class="tooltip-docs">Result</div>
											<i class="fa fa-sort-down"></i>
										</button>
										<button class="tooltip-btn btn-copy">
											<div class="tooltip-docs">Copy</div>
											<i class="fa fa-copy"></i>
										</button>
									</div>

								</div>
								<div class="content">
									<pre>
										<code>
&lt;List&gt;
    &lt;item&gt;
        &lt;id&gt;0&lt;/id&gt;
        &lt;idBook&gt;3&lt;/idBook&gt;
        &lt;title&gt;Chap 21: BÍ MẬT TRONG CĂN PHÒNG KÍN&lt;/title&gt;
        &lt;alias&gt;chap-21&lt;/alias&gt;
        &lt;urlChap&gt;https://truyenonline.info/conan/tap-21-bi-mat-trong-can-phong-kin&lt;/urlChap&gt;
    &lt;/item&gt;
    &lt;item&gt;
        &lt;id&gt;0&lt;/id&gt;
        &lt;idBook&gt;3&lt;/idBook&gt;
        &lt;title&gt;Chap 22: QUYỀN THỪA KẾ&lt;/title&gt;
        &lt;alias&gt;chap-22&lt;/alias&gt;
        &lt;urlChap&gt;https://truyenonline.info/conan/tap-22-quyen-thua-ke&lt;/urlChap&gt;
    &lt;/item&gt;
    &lt;item&gt;
        &lt;id&gt;0&lt;/id&gt;
        &lt;idBook&gt;3&lt;/idBook&gt;
        &lt;title&gt;Chap 23: BI KỊCH GIA ĐÌNH&lt;/title&gt;
        <h4>...</h4>
&lt;/List&gt;
										</code>
									</pre>
									<div class="tools">
										<button class="tooltip-btn btn-copy">
											<div class="tooltip-docs">Copy</div>
											<i class="fa fa-copy"></i>
										</button>
									</div>
								</div>
							</div>
					</div>
					<!-- end - 2 -->
					<!-- 3 -->
				<div class="paragraph">
				<h4 class="text-info ml-3">One chapter by Id</h4>
					<div class="json">
						<h5 class="ml-5">JSON</h5>
						<p class="sub-header">API call</p>
						<div class="api">
							<code>api-comic-conan.herokuapp.com/chap/{id}.json</code>
							<div class="tools">
								<button class="tooltip-btn btn-copy">
									<div class="tooltip-docs">Copy</div>
									<i class="fa fa-copy"></i>
								</button>
							</div>
						</div>
						<p class="sub-header">Examples of API calls:</p>
							<div class="response">
								<div class="api">
									<code>api-comic-conan.herokuapp.com/chap/3.json</code>
									<div class="tools">
										<button class="tooltip-btn btn-res">
											<div class="tooltip-docs">Result</div>
											<i class="fa fa-sort-down"></i>
										</button>
										<button class="tooltip-btn btn-copy">
											<div class="tooltip-docs">Copy</div>
											<i class="fa fa-copy"></i>
										</button>
									</div>

								</div>
								<div class="content">
									<pre>
										<code>
{
    "id": 3,
    "idBook": 0,
    "title": "Chap 21: BÍ MẬT TRONG CĂN PHÒNG KÍN",
    "alias": "chap-21",
    "urlChap": "https://truyenonline.info/conan/tap-21-bi-mat-trong-can-phong-kin"
}
										</code>
									</pre>
									<div class="tools">
										<button class="tooltip-btn btn-copy">
											<div class="tooltip-docs">Copy</div>
											<i class="fa fa-copy"></i>
										</button>
									</div>
								</div>
							</div>
					</div>
					<div class="xml">
						<h5 class="ml-5">XML</h5>
						<p class="sub-header">API call</p>
						<div class="api">
							<code>api-comic-conan.herokuapp.com/chap/{id}.xml</code>
							<div class="tools">
								<button class="tooltip-btn btn-copy">
									<div class="tooltip-docs">Copy</div>
									<i class="fa fa-copy"></i>
								</button>
							</div>
						</div>
						<p class="sub-header">Examples of API calls:</p>
							<div class="response">
								<div class="api">
									<code>api-comic-conan.herokuapp.com/chap/3.xml</code>
									<div class="tools">
										<button class="tooltip-btn btn-res">
											<div class="tooltip-docs">Result</div>
											<i class="fa fa-sort-down"></i>
										</button>
										<button class="tooltip-btn btn-copy">
											<div class="tooltip-docs">Copy</div>
											<i class="fa fa-copy"></i>
										</button>
									</div>

								</div>
								<div class="content">
									<pre>
										<code>
&lt;Chap&gt;
    &lt;id&gt;3&lt;/id&gt;
    &lt;idBook&gt;0&lt;/idBook&gt;
    &lt;title&gt;Chap 21: BÍ MẬT TRONG CĂN PHÒNG KÍN&lt;/title&gt;
    &lt;alias&gt;chap-21&lt;/alias&gt;
    &lt;urlChap&gt;https://truyenonline.info/conan/tap-21-bi-mat-trong-can-phong-kin&lt;/urlChap&gt;
&lt;/Chap&gt;
										</code>
									</pre>
									<div class="tools">
										<button class="tooltip-btn btn-copy">
											<div class="tooltip-docs">Copy</div>
											<i class="fa fa-copy"></i>
										</button>
									</div>
								</div>
							</div>
					</div>
					<!-- end - 3 -->
				</div>
			</div>
			<!-- end - II -->
<!-- III -->
			<div class="paragraph">
				<h3 class="text-info mb-3">Get data page</h3>

				<!-- 1 -->
				<div class="paragraph ml-4">
				<h4 class="text-info">All pages by Id chapter</h4>
					<div class="json">
						<h5 class="ml-5">JSON</h5>
						<p class="sub-header">API call</p>
						<div class="api">
							<code>api-comic-conan.herokuapp.com/chap/{id}/pages.json</code>
							<div class="tools">
								<button class="tooltip-btn btn-copy">
									<div class="tooltip-docs">Copy</div>
									<i class="fa fa-copy"></i>
								</button>
							</div>
						</div>
						<p class="sub-header">Examples of API calls:</p>
							<div class="response">
								<div class="api">
									<code>api-comic-conan.herokuapp.com/chap/3/pages.json</code>
									<div class="tools">
										<button class="tooltip-btn btn-res">
											<div class="tooltip-docs">Result</div>
											<i class="fa fa-sort-down"></i>
										</button>
										<button class="tooltip-btn btn-copy">
											<div class="tooltip-docs">Copy</div>
											<i class="fa fa-copy"></i>
										</button>
									</div>

								</div>
								<div class="content">
									<pre>
										<code>
[
    {
        "idChap": 3,
        "urlImg": "https://img.sachvui.com/images/2018/13/chap-3-0.jpg"
    },
    {
        "idChap": 3,
        "urlImg": "https://img.sachvui.com/images/2018/13/chap-3-1.jpg"
    },
    {
        "idChap": 3,
        "urlImg": "https://img.sachvui.com/images/2018/13/chap-3-2.jpg"
    },
		      				<h4>...</h4>
]
										</code>
									</pre>
									<div class="tools">
										<button class="tooltip-btn btn-copy">
											<div class="tooltip-docs">Copy</div>
											<i class="fa fa-copy"></i>
										</button>
									</div>
								</div>
							</div>
					</div>
					<div class="xml">
						<h5 class="ml-5">XML</h5>
						<p class="sub-header">API call</p>
						<div class="api">
							<code>api-comic-conan.herokuapp.com/chap/{id}/pages.xml</code>
							<div class="tools">
								<button class="tooltip-btn btn-copy">
									<div class="tooltip-docs">Copy</div>
									<i class="fa fa-copy"></i>
								</button>
							</div>
						</div>
						<p class="sub-header">Examples of API calls:</p>
							<div class="response">
								<div class="api">
									<code>api-comic-conan.herokuapp.com/chap/3/pages.xml</code>
									<div class="tools">
										<button class="tooltip-btn btn-res">
											<div class="tooltip-docs">Result</div>
											<i class="fa fa-sort-down"></i>
										</button>
										<button class="tooltip-btn btn-copy">
											<div class="tooltip-docs">Copy</div>
											<i class="fa fa-copy"></i>
										</button>
									</div>

								</div>
								<div class="content">
									<pre lang="xml">
										<code>
&lt;List&gt;
    &lt;item&gt;
        &lt;idChap&gt;3&lt;/idChap&gt;
        &lt;urlImg&gt;https://img.sachvui.com/images/2018/13/chap-3-0.jpg&lt;/urlImg&gt;
    &lt;/item&gt;
    &lt;item&gt;
        &lt;idChap&gt;3&lt;/idChap&gt;
        &lt;urlImg&gt;https://img.sachvui.com/images/2018/13/chap-3-1.jpg&lt;/urlImg&gt;
    &lt;/item&gt;
    &lt;item&gt;
        &lt;idChap&gt;3&lt;/idChap&gt;
        &lt;urlImg&gt;https://img.sachvui.com/images/2018/13/chap-3-2.jpg&lt;/urlImg&gt;
    &lt;/item&gt;
	    					<h4>...</h4>
&lt;/List&gt;   		
										</code>
									</pre>
									<div class="tools">
										<button class="tooltip-btn btn-copy">
											<div class="tooltip-docs">Copy</div>
											<i class="fa fa-copy"></i>
										</button>
									</div>
								</div>
							</div>
					</div>
					<!-- end - 1 -->
				</div>
			</div>
			<!-- end - III -->

		</div>

	</div>

	<script type="text/javascript">
		$(".btn-res").click(function() {
			var attrClass = $(this).children("i").attr("class");
			console.log(attrClass);
			if(attrClass == "fa fa-sort-down") {
				$(this).children("i").attr("class", "fa fa-sort-up");
				$(this).closest(".api").closest(".response").addClass("open");
			} else {
				$(this).children("i").attr("class", "fa fa-sort-down");
				$(this).closest(".api").closest(".response").removeClass("open");
			}
			 
		});

		$(".btn-copy").click(function() {
			var $temp = $("<input>");
			$("body").append($temp);
			var classParent = $(this).parent().parent().attr("class");
			if(classParent == "api") {
				$temp.val($(this).parent().parent().children("code").text()).select();
			} else if(classParent == "content"){
				$temp.val($(this).parent().parent().children("pre").children("code").text()).select();
			}
			
			
			 document.execCommand("copy");
		  $temp.remove();
		});

		
	</script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../../common/commonTaglid.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Sản phẩm</title>

<!-- Bootstrap Core CSS -->
<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="${contextPath}/resources/css/metisMenu.min.css" rel="stylesheet">

<!-- DataTables CSS -->
<link href="${contextPath}/resources/css/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link href="${contextPath}/resources/css/dataTables.responsive.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="${contextPath}/resources/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="${contextPath}/resources/css/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>
<body>
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Tables</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">DataTables Advanced Tables</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
							<thead>
								<tr>
									<th>Rendering engine</th>
									<th>Browser</th>
									<th>Platform(s)</th>
									<th>Engine version</th>
									<th>CSS grade</th>
								</tr>
							</thead>
							<tbody>
								<tr class="odd gradeX">
									<td>Trident</td>
									<td>Internet Explorer 4.0</td>
									<td>Win 95+</td>
									<td class="center">4</td>
									<td class="center">X</td>
								</tr>
								<tr class="even gradeC">
									<td>Trident</td>
									<td>Internet Explorer 5.0</td>
									<td>Win 95+</td>
									<td class="center">5</td>
									<td class="center">C</td>
								</tr>
								<tr class="odd gradeA">
									<td>Trident</td>
									<td>Internet Explorer 5.5</td>
									<td>Win 95+</td>
									<td class="center">5.5</td>
									<td class="center">A</td>
								</tr>
								<tr class="even gradeA">
									<td>Trident</td>
									<td>Internet Explorer 6</td>
									<td>Win 98+</td>
									<td class="center">6</td>
									<td class="center">A</td>
								</tr>
								<tr class="odd gradeA">
									<td>Trident</td>
									<td>Internet Explorer 7</td>
									<td>Win XP SP2+</td>
									<td class="center">7</td>
									<td class="center">A</td>
								</tr>
								<tr class="even gradeA">
									<td>Trident</td>
									<td>AOL browser (AOL desktop)</td>
									<td>Win XP</td>
									<td class="center">6</td>
									<td class="center">A</td>
								</tr>
							</tbody>
						</table>
						<!-- /.table-responsive -->
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
		</div>
	</div>
	<!-- /#page-wrapper -->

	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="${contextPath}/resources/js/jquery-1.12.4.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="${contextPath}/resources/js/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script src="${contextPath}/resources/js/jquery.dataTables.min.js"></script>
	<script src="${contextPath}/resources/js/dataTables.bootstrap.min.js"></script>
	<script src="${contextPath}/resources/js/dataTables.responsive.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="${contextPath}/resources/js/sb-admin-2.js"></script>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>

</body>
</html>
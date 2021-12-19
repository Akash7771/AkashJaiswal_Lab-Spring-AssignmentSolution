<%@include file="header.jsp" %>

<div class="container">
	<a href="${pageContext.request.contextPath}/student-list">Back to List</a>
	<p class="h4 mb-4">Enroll Student for Debate</p>
	
	<form action="${pageContext.request.contextPath}/saveStudentForm" method="POST">
		<!-- Add hidden form field to handle update -->
		<input type="hidden" name="studentId" value="" />

		<div class="form-inline">
			<input type="text" name="name" value=""
				class="form-control mb-4 col-4" placeholder="Name">
		</div>
		<div class="form-inline">
			<input type="text" name="department" value=""
				class="form-control mb-4 col-4" placeholder="Department">
		</div>
		<div class="form-inline">
			<input type="text" name="country" value=""
				class="form-control mb-4 col-4" placeholder="Country">
		</div>
		<button type="submit" class="btn btn-info col-2">Add Student</button>
	</form>
	<hr>
	
</div>

<%@include file="footer.jsp" %>
<%@include file="header.jsp" %>

<div class="container">
	<a href="${pageContext.request.contextPath}/student-list">Back to List</a>
	<p class="h4 mb-4">Update Student for Debate</p>
	<form action="${pageContext.request.contextPath}/updateStudentForm?studentId=${theStudent.studentId}" method="POST">
		<!-- Add hidden form field to handle update -->
		
		<div class="form-inline">
			<input type="text" name="name" value="${theStudent.name}"
				class="form-control mb-4 col-4" placeholder="Name">
		</div>
		<div class="form-inline">
			<input type="text" name="department" value="${theStudent.department}"
				class="form-control mb-4 col-4" placeholder="Department">
		</div>
		<div class="form-inline">
			<input type="text" name="country" value="${theStudent.country}"
				class="form-control mb-4 col-4" placeholder="Country">
		</div>
		<button type="submit" class="btn btn-info col-2">Update Student</button>
	</form>
	<hr>
	
</div>

<%@include file="footer.jsp" %>
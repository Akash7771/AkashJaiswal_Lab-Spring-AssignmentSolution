<%@include file="header.jsp" %>
<div class="container">
					
	<!-- Add a button -->
	<a href="${pageContext.request.contextPath}/addStudent"
		class="btn btn-primary btn-sm mb-3"> Add Book </a> 

	<table class="table table-bordered table-striped">
		<thead class="thead-light">
			<tr>
				<th>#Student ID</th>
				<th>Name</th>
				<th>Department</th>
				<th>Country</th>
				<th>Action</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${theStudents}" var="student">
				<tr>
					<td><c:out value="${student.studentId}" /></td>
					<td><c:out value="${student.name}" /></td>
					<td><c:out value="${student.department}" /></td>
					<td><c:out value="${student.country}" /></td>
					<td>
						<a
						href="${pageContext.request.contextPath}/updateStudent?studentId=${student.studentId}"
						class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
						<a href="${pageContext.request.contextPath}/deleteStudent?studentId=${student.studentId}"
						class="btn btn-danger btn-sm"
						onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">
							Delete </a>

					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>

<%@include file="footer.jsp" %>
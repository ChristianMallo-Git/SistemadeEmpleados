<%@ include file="common/headboard.jsp"%>

<%@ include file="common/navigation.jsp"%>

<div class="container">
    <div class="text-center" style="margin: 30px">
        <h3>Add Employee</h3>
    </div>
    <form action="${urlAdd}" modelAttribute="employeeForm" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name" name="nameEmployee" required="true"> <!-- En name tiene que
                                                                                                     aparecer el mismo nombre que en la
                                                                                                     clase modelo de Employee -->
        </div>
        <div class="mb-3">
            <label for="department" class="form-label">Department</label>
            <input type="text" class="form-control" id="department" name="departmentEmployee">
        </div>
        <div class="mb-3">
            <label for="salary" class="form-label">Salary</label>
            <input type="number" step="any" class="form-control" id="salary" name="salaryEmployee">
        </div>
        <div class="text-center" >
            <button type="submit" class="btn btn-warning btn-sm me-3">Add</button>
            <a href="${urlHome}" class="btn btn-danger btn-sm">Return</a>
        </div>
    </form>
</div>

<%@ include file="common/footer.jsp"%>
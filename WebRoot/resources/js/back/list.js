
function createNew(basePath){
	//alert("create");
	$("#createForm").attr("action",basePath + "AddServlet.action");
	$("#createForm").submit();
}

/**
 * 调用后台批量删除方法
 */
function deleteBatch(basePath) {
	$("#mainForm").attr("action",basePath + "DeleteServlet.action");
	$("#mainForm").submit();
}

/**
 * 修改当前页码，调用后台重新查询
 */
function changeCurrentPage(currentPage) {
	$("#currentPage").val(currentPage);
	$("#mainForm").submit();
}


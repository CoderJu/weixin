/**
 * 调用后台批量删除方法
 */
function deleteBatch(basePath) {
	//alert("hehe");
	$("#mainForm").attr("action",basePath + "DeleteServlet.action");
	$("#mainForm").submit();
}

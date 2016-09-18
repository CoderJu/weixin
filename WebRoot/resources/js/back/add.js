//清除
function clean(basePath) {
	//alert("clean");
	$("#cleanForm").attr("action",basePath + "AddServlet.action");
	$("#cleanForm").submit();
	//$("#command").val();
	//$("#description").val();
	//$("#content").val();
}

//新增
function add(basePath) {
	//alert("add");
	$("#addForm").attr("action",basePath + "AddServlet.action");
	$("#addForm").submit();
}
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>502 jsp study</title>
	<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<link  rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
	<style>
		body *{
			font-family: 'jua';
	    }
	    img.small {
	    	width: 30px;
	    	height: 30px;
	    	border: 1px solid gray;
	    	margin-right: 5px;
	    }
	</style>
</head>
<body>
<jsp:include page="../../layout/title.jsp"/>
<div style="margin: 20px;width: 650px;">
	<table class="table table-bordered tab1">
		<thead>
			<tr>
				<th width="150">
				<input type="checkbox" class="allchk">
				회원명</th>	
				<th width="100">아이디</th>
				<th width="150">핸드폰</th>
				<th width="180">주소</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="dto" items="${memberlist}">
			<tr>
				<td>
				<input type="checkbox" class="numchk" num="${dto.num}">
				<%-- <%-- <img src="../save/${dto.mphoto}" class="small" 
				onerror="this.src='../save/noimage.png'"> --%>
				<!-- 원본 사진을 사이즈만 바꿔서 출력 -->
				<%-- <img src="${naverurl}/member/${dto.mphoto}" class="small" 
				onerror="this.src='../save/noimage.png'"> --%>
				<!-- 원본사진에서 30x30 사이즈로 자른 썸네일 출력 -->
				<img src="${fronturl}/member/${dto.mphoto}${backurl}" class="small" 
				onerror="this.src='../save/noimage.png'">
				${dto.mname}</td>
				<td>${dto.myid}</td>
				<td>${dto.mhp}</td>
				<td>${dto.maddr}</td>
				<td>
					<button type="button" class="btn btn-sm btn-danger"
					onclick="memdel(${dto.num})">탈퇴</button>
					
					<script type="text/javascript">
						function memdel(num) {
							let ans = confirm("해당 멤버를 탈퇴시키겠습니까 ?")
							if(ans) {
								location.href='./delete?num='+num;
							}
						}
					</script>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<button type="button" class="btn btn-sm btn-outline-secondary"
	style="margin: 20px;" id="delmember">선택한 회원 강제 탈퇴</button>
</div>
<script type="text/javascript">
	$(".allchk").click(function() {
		let chk = $(this).is(":checked");
		//alert(chk);
		$(".numchk").prop("checked",chk);
	});
	
	$("#delmember").click(function() {
		let len = $(".numchk:checked").length;
		//alert(len);
		if(len == 0) {
			alert("탈퇴시킬 멤버를 체크해주세요");
			return;
		}
		let nums = "";
		$(".numchk:checked").each(function(idx,item) {
			nums += $(this).attr("num") + ",";
		});
		//마지막 컴마 제거하기
		nums = nums.substring(0,nums.length-1);
		//alert(nums);
		if(!confirm("체크된 멤버를 탈퇴시킬까요?")) {
			return;
		}
		
		$.ajax({
			type:"get",
			dataType:"text",
			data:{"nums":nums},
			url:"./checkdel",
			success:function() {
				location.reload();
			}
		});
	});
</script>
</body>
</html>
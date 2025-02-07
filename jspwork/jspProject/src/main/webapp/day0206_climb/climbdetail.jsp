<%@page import="climb.data.ClimbDto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="climb.data.ClimbDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
        <link  rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
 <%
	//1. num 읽기
	int num=Integer.parseInt(request.getParameter("num"));
	//2. dao 선언
	ClimbDao dao = new ClimbDao();
	//3. num 에 해당하는 dto 얻기(dao 에 메서드 추가해야함: getSangpum(int num))
	ClimbDto dto = dao.getClimb(num);
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
        <style>
            body *{
                font-family: 'jua';
                
            }
            
            .btn {
	        	width:100px;
	        }
	        
	        .replelist b {
	        	cursor: pointer;
	        }
	        
	        .replelist div {
	        	font-size: 13px;
	        	font-family: 'gaegu';
	        }
	        
	        .replelist .day {
	        	font-size: 12px;
	        	color: gray;
	        }
	        
	        .star {
	        	font-size: 13px;
	        }
	        
	        span.close {
	        	cursor: pointer;
	        	color: red;
	        	font-size: 18px;
	        	margin-left: 20px;
	        }
	        
	        div {
		        background-image: url('../image/climb/bg2.jpg');

	            background-position: center;
	            background-attachment: fixed;
	        }
        </style>
        <script type="text/javascript">
        	$(function(){
        		list();//처음 로딩 시 상품평 출력
         		//상품평 등록버튼
         		$("#btnreple").click(function(){
         			let num = <%=num%>;
         			let star = $(".selstar").val();
         			let mes = $("#message").val();
         			
         			$.ajax({
         				type:"get",
         				dataType:"html",
         				data:{"num":num,"star":star,"message":mes},
         				url:"./insertreple.jsp",
         				success:function() {
         					//상품평 등록 후 목록 다시 출력
         					list();
         					
         					//입력값 초기화
         					$(".selstar").val(5);
         					$("#message").val("");
         				}
         			});
         		});
        		
         		//상품평 삭제 이벤트
         		$(document).on("click","span.close",function(){
         			let idx = $(this).attr("idx");
         			if(confirm("해당 상품평을 삭제할까요 ?")){
         				$.ajax({
         					type:"get",
         					dataType:"html",
         					data:{"idx":idx},
         					url:"./deletereple.jsp",
         					success:function(){
         						list();
         					}
         				});
         			}
         		});
         		//상품평 나타내기/숨기기
         		$(".replelist>b").click(function(){
         			$(this).next().slideToggle('fast');
         		});
         		
        	});
        	
        	function list() {
        		$.ajax({
         			type:"get",
         			dataType:"json",
         			data:{"num":<%=num%>},
         			url:"./listreple.jsp",
         			success:function(res) {
         				let n = $(res).length;
         				$(".replelist>b").text("총"+n+"개");
         				//상품명 목록 출력
         				let s = "";
         				$.each(res,function(idx,ele){
         					for(let i=1;i<=ele.star;i++) {
         						s += `<i class="bi bi-star-fill star"></i>`;
         					}
         					
         					for(let i=1;i<=5-ele.star;i++) {
         						s+= `<i class="bi bi-star star"></i>`;
         					}
         					s += `<span class="day">\${ele.writeday}</span>`;
         					s += "<br>";
         					s += `<span style="margin-left:10px;">\${ele.message}</span>`;
         					
         					s += `<span class="close" idx="\${ele.idx}"><i class="bi bi-x"></i></span>`;
         					s += "<br>"
         				});
         				$(".replelist>div").html(s);
         				
         			}
         		});
        	}
        </script>
    </head>
    <body>
    
    <div class="modal" id="climbUpdateModal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">후기 수정</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       
       <!-- 이번에 수정은 폼단위로 값을 얻어보자 -->
       <form id="climbupdateform">
			<input type="hidden" name="num" value="<%=num %>">
       
		<table class="table table-bordered">
			<tr>
				<td width="100" style="background-color: lightgray;">클라이밍장 사진</td>
				<td>
					<select id="cphoto" name="cphoto" class="form-select">
						  <script>
						  	for(let i=1;i<=4;i++){
						  		let s = "";
						  		let cphoto = `../image/climb/\${i}.png`;
						  		let dbphoto = "<%=dto.getCphoto()%>"
					  			if(cphoto==dbphoto)
						  			s=`<option value='\${cphoto}' selected> \${i}</option>`;
						  		else 
						  			s=`<option value='\${cphoto}'> \${i}</option>`;
						  		document.write(s);
						  	}
						  </script>		
					 </select>
					 <br>
					<img src="" class="climbphoto" width="100">
					
					<script type="text/javascript">
						$(".climbphoto").attr("src",$("#cphoto").val());
						
						//이벤트
						$("#cphoto").change(function(){
							$(".climbphoto").attr("src",$(this).val());
						});
					</script>
			 </td>
			</tr>
			<tr>
				<td style="background-color: lightgray;">클라이밍장 이름</td>
				<td>
					<input type="text" name="cname" id="cname"
				class="form-control">	
				</td>
			</tr>
			<tr>
				<td style="background-color: lightgray;">일일권 가격</td>
				<td>
					<input type="number" name="cprice" id="cprice" 
					  class="form-control" min="0">
				</td>
			</tr>
			<tr>
				<td style="background-color: lightgray;">방문일자</td>
				<td>
					<input type="date" name="cday" id="cday" 
					  class="form-control" value="2025-01-01">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit"  data-bs-dismiss="modal"
					style=width:120px;"
					class="btn btn-sm btn-success">수정하기</button>
				</td>
			</tr>			
		</table>
			
       </form>
      </div>
      
       <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" 
        data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>
    <!-- table 을 이용해서 상세페이지 만들기, 
맨아래에 수정,삭제,목록버튼 넣기 -->
<div style="margin: 20px;width: 550px;">
	<table class="tab1">
		<tr>
			<td>
				<img src="<%=dto.getCphoto()%>"
				 width="230" height="300" border="1">
			</td>
			<td valign="middle">
				<h6 style="color: #9370d8;">클라이밍장 : <%=dto.getCname()%></h6>
				<h6 style="color: #9370d8;">일일권 가격 : <%=dto.getCprice()%>원</h6>
				<h6 style="color: #9370d8;">다녀온 날 : <%=dto.getCday()%></h6>
				<h6 style="color: #9370d8;">등록일 : <%=sdf.format(dto.getWriteday()) %></h6>
				<button type="button" class="btn btn-sm btn-outline-success" onclick="location.href='<%=dto.getCurl()%>'">링크</button>
				
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<h6><b>클라이밍장 후기</b></h6>
				<div class="repleform input-group">
					<select class="form-select selstar" style="width: 70px;">
					<option value="5">⭐⭐⭐⭐⭐ (5점)</option>
		            <option value="4">⭐⭐⭐⭐ (4점)</option>
		            <option value="3">⭐⭐⭐ (3점)</option>
		            <option value="2">⭐⭐ (2점)</option>
		            <option value="1">⭐ (1점)</option>
					</select>
					<input type="text" id="message" class="form-control"
					placeholder="후기를 써보세요 😊" style="width:280px">
					
					<button type="button" class="btn btn-sm btn-info"
					id="btnreple">등록</button>
				</div>
				<div class="replelist" style="margin-top: 10px;">
					<b>0</b>
					<div style="margin-left: 10px;">1</div>
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="button" class="btn btn-outline-info btn-sm"
				id="btnupdate" data-bs-toggle="modal" 
				data-bs-target="#climbUpdateModal">수정</button>
				
				<button type="button" class="btn btn-outline-danger btn-sm"
				id="btndelete">삭제</button>
				
				<button type="button" class="btn btn-outline-warning btn-sm"
				onclick="location.href='./climbmain.html'">목록</button>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
	
	$("#btndelete").click(function(){
		//confirm 으로 물어보고 [확인]을 누르면 삭제
		//ajax 함수를 이용해서 한다
		//data로는 num 을 보낸다
		//success 에서 목록으로 이동
		
		let a=confirm("현재 상품을 삭제하시겠습니까?");
		if(a){
			$.ajax({
				type:"get",
				dataType:"html",
				data:{"num":<%=num%>},
				url:"./deleteclimb.jsp",
				success:function(){
					alert("현재 상품을 삭제했습니다");
					location.href="./climbmain.html";
				}
			});
		}
		
	});
	
	$("#climbupdateform").submit(function(e){
		//기본 이벤트 무효화
		e.preventDefault();
		//폼단위 데이타 모두 얻기
		let d=$(this).serialize();
		//alert(d);
		$.ajax({
			type:"get",
			dataType:"html",
			data:d,
			url:"./updateclimb.jsp",
			success:function(){
				//수정 성공후 새로고침
				location.reload();
			}
			
		});
	});
	</script>
</div>
</body>
</html>
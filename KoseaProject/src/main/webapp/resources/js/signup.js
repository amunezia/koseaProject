
  $('#datepicker').datepicker({
	  changeMonth: true,
	  changeYear: true,
	  yearRange: "1950:2025", // 연도 범위 설정
	  showButtonPanel: true,
	  dateFormat: 'yy-mm-dd'
  });

  $(document).ready(function(){
  	$("#idcheck").on("click",function(event){
  		event.preventDefault();
  		var userId=$("#userId").val();
  		
  		$.ajax({
  			type:"POST",
  			url:"/idcheck",
  			contentType:"application/json; charset=UTF-8",
  			dataType:"json",
  			data:JSON.stringify({userId}),
  			success:function(idcheck){
  				if(idcheck==0){
  					$("#checkResult").text("사용가능");
  				}else{
  					$("#checkResult").text("이미 사용중");
  				}
  			},
  			error:function(){
  				$("#checkResult").text("오류발생");
  			}
  		});
  	});
  });

	function ActivateCard(){
		$('#div_msg').hide();
		if($.trim($('#sequenceNumber').val())==''){
			showHint("Please enter then SequenceNumber.");
			return;
		}
		
		if($.trim($('#securityNumber').val())==''){
			showHint("Please enter the SecurityNumber.");
			return;
		}
		
		$("#loadingModal").modal({
			 backdrop:"static",
			 show:true
		});
	    $("#f_ActivateCard").form("submit",{  
		    success :function(data){
		    	var rs = JSON.parse(data);
		    	if(typeof(rs.msg) == "undefined" || rs.msg==null){
		    		alert("Binding success");
		    		window.location.href="main.jsp";
		    	} else {
		    		$("#loadingModal").modal('hide');
		    		showHint(rs.msg);
		    	}
		    },
		    error:function(data){  
		    	$("#loadingModal").modal('hide');
		       alert('error'+data); 
		    }
	    }); 
	}
	
	function showHint(msg){
		$('#div_msg').show();
		$('#msg').text(msg);
	}
	

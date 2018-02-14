/**
 * 
 */

var page = '${open}';
	$(document)
			.ready(
					function() {
						$('#mainbody>div').hide();
						$('#bookpage').show();
						$('#maintab>li').click(function(event) {
							$('#mainbody>div').hide();
							var name = $(this).children('a').attr('name');
							$(name).show();
						});
						// header
						$('body').on('click', '#headLoginBtn', function(e){
							location.href="/bmgr/login";
						});
						$('body').on('click', '#headLogoutBtn', function(e){
							if(confirm('로그아웃 하시겠습니까?')){
								location.href="/bmgr/logout";
							}
						});
						
						$('body').on('click', '#joinmember', function(event) {
							location.href="/bmgr/register";
						});
						$('body').on('click', '#memberinfo', function(event) {
							location.href="/bmgr/modifymember";
						});

						// 도서 페이지 도구툴
						$('#bsbtn').click(function(event) {
							var selec = 'bookname';
							if($('#bsselect option:selected').val()!=''){
								selec = $('#bsselect option:selected').val();
							}
							
							$('#searchtext').attr('name',selec);
						
							$('#bsrhform').submit();

						});
						$('body').on(
								'mouseover',
								'td.btd',
								function() {
									$(this).parent('tr').children('td')
											.addClass('tablehover');
								});
						$('body').on('mouseout', 'td.btd', function() {
							$('td.btd').removeClass('tablehover');
						});
						$('body')
								.on(
										'click',
										'td.btd',
										function() {
											var no = $(this).parent('tr')
													.children('td').eq(0)
													.text();
											$('input[name="no"]').val(no);
											var name = $(this).parent('tr')
													.children('td').eq(1)
													.text();
											$('input[name="bookname"]').val(
													name);
											var category = $(this).parent('tr')
													.children('td').eq(2)
													.text();
											$('input[name="category"]').val(
													category);
											var author = $(this).parent('tr')
													.children('td').eq(3)
													.text();
											$('input[name="author"]').val(
													author);
											var publisher = $(this)
													.parent('tr')
													.children('td').eq(4)
													.text();
											$('input[name="publisher"]').val(
													publisher);
											var price = $(this).parent('tr')
													.children('td').eq(5)
													.text();
											$('input[name="price"]').val(price);
										});
						$('#bmbtn').click(
								function(event) {
									$('#btxtbox').attr('action',
											'/bmgr/modibook').submit();
								});
						$('#bdbtn').click(
								function(event) {
									$('#btxtbox').attr('action',
											'/bmgr/delbook').submit();
								});
						$('#brrbtn')
								.click(
										function(event) {
											var bookno = $('#bookpage input[name="no"]').val();
											$.ajax({
							                    url : '/bmgr/bookbrryn'
							                    , data: JSON.stringify(  {'no':bookno}  )       // 사용하는 경우에는 { data1:'test1', data2:'test2' }
							                    , type: 'post'       // get, post
							                    , timeout: 30000    // 30초
							                    , dataType: 'html'  // text, html, xml, json, jsonp, script
							                        , headers: {'Accept': 'application/json', 'Content-Type':'application/json'}
							                }).done( function(data, textStatus, xhr ){
							                    // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
							                	if(data==1){
							                		alert('대여중입니다.');
							                	}
							                	else {
							                		$('#btxtbox').attr("action",
													"/bmgr/borrowbook");
								                	$('#btxtbox')
													.attr("method", "post");
								                	$('#btxtbox')
													.attr("target", "도서대여");
								                	window
													.open(
															"",
															"도서대여",
															"height=500, width=900, menubar=no, scrollbars=yes, resizable=no, toolbar=no, status=no, left=50, top=50");
								                	$('#btxtbox').submit();
							                	}
							                	
							                }).fail( function(xhr, textStatus, error ) {
							                    // 통신이 실패했을 때 이 함수를 타게 된다.
							                    alert('error');
							                }).always( function(data, textStatus, xhr ) {
							                    // 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
							                }); 
											

										});

						// 멤버 페이지 도구툴
						$('#msbtn').click(function(event) {
							$('#msrhform').submit();

						});
						$('body').on(
								'mouseover',
								'td.mtd',
								function() {
									$(this).parent('tr').children('td')
											.addClass('tablehover');
								});
						$('body').on('mouseout', 'td.mtd', function() {
							$('td.mtd').removeClass('tablehover');
						});
						$('body')
								.on(
										'click',
										'td.mtd',
										function() {
											var memNo = $(this).parent('tr')
													.children('td').eq(0)
													.text();
											$('input[name="memNo"]').val(memNo);
											var memName = $(this).parent('tr')
													.children('td').eq(1)
													.text();
											$('input[name="memName"]').val(
													memName);
											var memPriNum = $(this)
													.parent('tr')
													.children('td').eq(2)
													.text();
											$('input[name="memPriNum"]').val(
													memPriNum);
											var memPhone = $(this).parent('tr')
													.children('td').eq(3)
													.text();
											$('input[name="memPhone"]').val(
													memPhone);
											var memEmail = $(this).parent('tr')
													.children('td').eq(4)
													.text();
											$('input[name="memEmail"]').val(
													memEmail);
										});
						$('#mmbtn').click(
								function(event) {
									$('#mtxtbox').attr('action',
											'/bmgr/modimem').submit();
								});
						$('#mdbtn').click(
								function(event) {
									$('#mtxtbox')
											.attr('action', '/bmgr/delmem')
											.submit();
								});

						// 대여 페이지 도구툴

						$('body').on(
								'mouseover',
								'td.brtd',
								function() {
									$(this).parent('tr').children('td')
											.addClass('tablehover');
								});
						$('body').on('mouseout', 'td.brtd', function() {
							$('td.brtd').removeClass('tablehover');
						});
						$('body').on(
								'click',
								'td.brtd',
								function() {
									var brno = $(this).parent('tr').children(
											'td').eq(0).text();
									$('input[name="brno"]').val(brno);
								});
					});
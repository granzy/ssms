/**
 * 菜单
 */
$(function() {

    var menu = {};
    menu.content = $('#main-content');
    $('.menu-main li a').click(function (e) {
        $.ajax({
            url:$(this).attr('menuUrl'),
            type:'POST',
            dataType:'html',
            success : function(data, textStatus, jqXHR) {
                menu.content.empty();
                menu.content.html(data);
            }
        });
    });

});

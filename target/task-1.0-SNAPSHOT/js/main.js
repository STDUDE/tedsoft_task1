$(document).ready(function(){
// ====================================================== //
    var array = new Array;

    var j = 0;
    var jVal = {
        'keyword' : function() {

            $('body').append('<div id="keywordInfo" class="info"></div>');

            var keywordInfo = $('#keywordInfo');
            var ele = $('#first');
            var pos = ele.offset();

            keywordInfo.css({
                top: pos.top,
                left: pos.left+ele.width()+29
            });

            if(ele.val().length == 0) {
                jVal.errors = true;
                keywordInfo.removeClass('correct').addClass('error').html(' ').show();
                keywordInfo.hide();
                setTimeout(function(){keywordInfo.show();setInterval(function(){keywordInfo.toggle();},500)},0);
                ele.removeClass('normal').addClass('wrong');
            } else {
                keywordInfo.removeClass('error').addClass('correct').html(' ').show();
                ele.removeClass('wrong').addClass('normal');
            }
        },
        'sendIt' : function (){
            if(!jVal.errors) {
                $('#keywordInfo').remove();
                $('#myform')[0].reset();
            }
        }
    };

// ====================================================== //

    $('#turn_button').click(function (){
        var keyword = $('#keyword').val();
        console.log(keyword);
        ajaxSendRequest(keyword);
    });

    //$('#keyword').change(jVal.keyword);

// ====================================================== //

});




function ajaxSendRequest(keyword) {
    $.ajax
    ({
        type: "POST",
        url: './task/turn',
        dataType: 'json',
        async: false,
        //json object to sent to the authentication url
        data: JSON.stringify({ "keyword": keyword }),
        success: function (data) {
            console.log(data);
            var str_json = JSON.stringify(data);
            var json = JSON.parse(str_json);
            alert(json.response);
        },
        error: function () {
            alert("Bad!");
        }
    })
}
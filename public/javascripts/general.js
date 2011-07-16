$(document).ready(function() {
    $(window).resize();
    $('.btn').button();
});

$(window).resize(function() {
    $('#splash').css('margin-top', $(window).height() / 2 - $('#splash').height() / 2);
});

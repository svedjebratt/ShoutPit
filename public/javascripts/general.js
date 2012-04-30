$(document).ready(function() {
    $(window).resize();
    $('.btn').button();
    $('#remove').click(function(e) {
        if (!confirm("Really delete Shout?")) {
            e.preventDefault();
        }
    });
});

$(window).resize(function() {
    $('#splash').css('margin-top', $(window).height() / 2 - $('#splash').height() / 2);
});

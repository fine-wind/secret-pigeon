function spAlert(title, body) {
    Notification.requestPermission().then(function (result) {
        if (result === 'denied' || result === 'default') {
            console.log('拒绝显示系统通知');
            return;
        }
        new Notification('有一条新通知', {
            dir: 'ltr',
            lang: 'zh-CN',
            body: '通知的正文内容：你的请假流程已批准',
            // icon: 'http://localhost/coder/favicon.ico'
        });
    });
}

function myReload(current) {
    let parents = current.parents('[data-iframe]');
    if (parents) {
        console.debug(parents)
        parents = $(parents[0])
        $.get(parents.data("iframe"), (res) => {
            parents.html(res)
        })
    }
}

$('a[data-iframe]').click((btn) => {
    const url = $(btn.currentTarget).data('iframe');
    $.get(url, (res) => {
        const children = $(btn.currentTarget).parent().parent().parent().children('[data-iframe]');
        children.attr('data-iframe', url)
        children.html(res)
    })
});
$('[data-add]').click((btn) => {
    const url = $(btn.currentTarget).data('add');
    const form = $(btn.currentTarget).parent().children('form').serialize();
    $.post(url, form, function () {
        myReload($(btn.currentTarget));
    });
});
$('[data-up]').click((btn) => {
    let $1 = $(btn.currentTarget);
    $.post($1.data('up'), $1.parent().children('form').serialize(), function (res) {
        spAlert(res, res)
        myReload($1);
    });
})
$('[data-del]').click((btn) => {
    let $1 = $(btn.currentTarget);
    $.post($1.data('del'), `id=${$1.data('id')}`, function () {
        location.reload();
    });
})
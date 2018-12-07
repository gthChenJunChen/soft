layui.use('form', function () {
    var table = layui.table;
    var tableTitle = [
        {type: 'checkbox', fixed: 'left'}
        , {field: 'id', title: 'ID', sort: true}
        , {field: 'albumName', title: '专题名称', width: 160}
        // , {field: 'albumImg', title: '专题图片', width: 160}
        , {field: 'anchor', title: '专题人员', width: 100, sort: true}
        , {field: 'publishDate', title: '发布时间', width: 110}
        , {field: 'introduce', title: '介绍', width: 200, sort: true}
        , {field: 'Valid', title: '状态',  width: 80,sort: true}
        , {field: 'rectime', title: '创建时间', width: 160, sort: true}
        , {field: 'modtime', title: '修改时间', width: 160, sort: true}
        , {field: 'creator', title: '创建人', width: 100, sort: true}
        , {field: 'editor', title: '修改人', width: 100, sort: true}
    ];
    table.render({
        elem: '#album_table'
        , height: 400
        , url: '/album' //数据接口
        , page: true //开启分页
        , cols: [tableTitle]
    });
});
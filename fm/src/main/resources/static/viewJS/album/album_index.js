layui.use('form', function () {
    var
        $ = layui.$
        , admin = layui.admin
        , view = layui.view
        , table = layui.table
        , form = layui.form;
    form.render(null, 'app-content-list');

    var tableTitle = [
        {type: 'checkbox', fixed: 'left'}
        , {field: 'id', title: 'ID', sort: true}
        , {field: 'albumName', title: '专题名称', width: 160}
        // , {field: 'albumImg', title: '专题图片', width: 160}
        , {field: 'anchor', title: '专题人员', width: 100, sort: true}
        , {field: 'publishDate', title: '发布时间', width: 110}
        , {field: 'introduce', title: '介绍', width: 200, sort: true}
        , {field: 'Valid', title: '状态', width: 80, sort: true}
        , {field: 'rectime', title: '创建时间', width: 160, sort: true}
        , {field: 'modtime', title: '修改时间', width: 160, sort: true}
        , {field: 'creator', title: '创建人', width: 100, sort: true}
        , {field: 'editor', title: '修改人', width: 100, sort: true}
    ];
    table.render({
        elem: '#LAY-app-content-list'
        , height: 400
        , url: '/album' //数据接口
        , page: true //开启分页
        , cols: [tableTitle]
    });
    //排序
    table.on('sort(LAY-app-content-list)', function (obj) {
        table.reload("LAY-app-content-list", {
            initSort: obj,
            where: {
                field: obj.field,
                order: obj.type
            }
        })
    })

    var active = {
        add: function (othis) {
            admin.popup({
                title: '新增'
                , area: ['550px', '470px']
                , id: 'LAY-popup-content-add'
                , success: function (layero, index) {
                    view(this.id).render('/album/edit').done(function () {
                        form.render(null, 'layuiadmin-app-form-list');
                        //监听提交
                        form.on('submit(layuiadmin-app-form-submit)', function (data) {
                            var field = data.field;                       //获取提交的字段
                             
                            layui.table.reload('LAY-app-content-list');   //重载表格
                            layer.close(index);                           //执行关闭
                        })
                    })

                }
            })
        }
    };
    $('.layui-btn.layuiadmin-btn-list').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    })
});
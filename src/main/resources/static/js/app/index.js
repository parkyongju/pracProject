var main = {
    init : function(){
        var _this = this;
        $("#btn-save").on('click' , function(){
            _this.save();
        });
        $("#btn-update").on('click' , function(){
            _this.update();
        });
        $("#btn-delete").on('click' , function(){
            _this.delete();
        });
    }
    ,save : function(){
        var data = {
            title : $("#title").val(),
            author : $("#author").val(),
            contents : $("#contents").val()
        };
        console.log(data);
        $.ajax({
            type:"POST"
            , url:"/api/v1/posts"
            , dataType:'json'
            , contentType:'application/json; charset=utf-8'
            , data : JSON.stringify(data)
        }).done(function(){
            alert('글 등록됨 ㅅㄱ');
            window.location.href = '/';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
    , update : function(){
        var data = {
            title : $("#title").val(),
            contents : $("#contents").val()
        };
        $.ajax({
            type:"PUT"
            , url:"/api/v1/posts/" + $("#id").val()
            , dataType:'json'
            , contentType:'application/json; charset=utf-8'
            , data : JSON.stringify(data)
        }).done(function(){
            alert('글 수정됨 ㅅㄱ');
            window.location.href = '/';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
    , delete : function(){
        var data = {
            title : $("#title").val(),
            contents : $("#contents").val()
        };
        $.ajax({
            type:"DELETE"
            , url:"/api/v1/posts/" + $("#id").val()
            , dataType:'json'
            , contentType:'application/json; charset=utf-8'
            , data : JSON.stringify(data)
        }).done(function(){
            alert('글 삭제됨 ㅅㄱ');
            window.location.href = '/';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
};
main.init();

var $copyContainer = $(".copy-container"),
        $replayIcon = $('#cb-replay'),
        $copyWidth = $('.copy-container').find('p').width();

var mySplitText = new SplitText($copyContainer, {type: "words"}),splitTextTimeline = new TimelineMax();
var handleTL = new TimelineMax();

// WIP - need to clean up, work on initial state and handle issue with multiple lines on mobile

var tl = new TimelineMax();

tl.add(function () {
    animateCopy();
    blinkHandle();
}, 0.2)

function animateCopy() {
    mySplitText.split({type: "chars, words"})
    splitTextTimeline.staggerFrom(mySplitText.chars, 0.001, {autoAlpha: 0, ease: Back.easeInOut.config(1.7), onComplete: function () {
            animateHandle()
        }}, 0.05);
}

function blinkHandle() {
    handleTL.fromTo('.handle', 0.4, {autoAlpha: 0}, {autoAlpha: 1, repeat: -1, yoyo: true}, 0);
}

function animateHandle() {
    handleTL.to('.handle', 0.7, {x: $copyWidth, ease: SteppedEase.config(12)}, 0.05);
}

$('#cb-replay').on('click', function () {
    splitTextTimeline.restart()
    handleTL.restart()
});
//
//$('a.alert').confirm({
//    title: 'Confirm!',
//    content: 'Simple confirm!',
//    buttons: {
//        confirm: function () {
//            a.alert('Confirmed!');
//        },
//        cancel: function () {
//            a.alert('Canceled!');
//        }
//    }
//});



$("#.delete").click(function(){

     $.confirm({

     title: 'Confirmation !!',

      content: 'Are you sure, delete this item?',

       buttons: {

        confirm: function () {
         // write your logic    
                 },      
         cancel: function () { 

        } }

        });


        });          
 
  function toggleState(item){
       if(item.className === "on") {
          document.getElementById("form").reset(); // очищает форму
          item.className="off"; 
       } else {
          item.className="on";
          let reg = document.getElementById("registration");
          reg.onclick = function(){ // назанчаем кнопке события отправляющего POST запрос на сервер
            var client = new postHttpRequest();
            client.post('ajax/registration',formData(), function(response){
                 document.getElementById("info").innerHTML = JSON.parse(response);
                 getListReaders(); // переписываем список пользователей
                 let el = document.getElementById('showRegistration');
                 toggleState(el); // переключаем видимость слоя регистрации
            });
          }; 
       };
    };
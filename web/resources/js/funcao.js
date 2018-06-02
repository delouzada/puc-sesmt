
function alturaframe() {
        altura = Math.max(
        Math.max(document.getElementById('base').scrollHeight),
        Math.max(document.getElementById('base').offsetHeight),
        Math.max(document.getElementById('base').clientHeight));
        topo = document.getElementById('base');
        
        altura = (altura/2);
//alert(altura);

        return  altura;
}

function larguraframe() {
        largura = Math.max(
        Math.max(document.getElementById('content').scrollWidth),
        Math.max(document.getElementById('content').offsetWidth),
        Math.max(document.getElementById('content').clientWidth));
        lado = document.getElementById('content');
 //alert(largura);     
        largura = ((largura)/2);
//alert(largura);

        return  largura;
}


PrimeFaces.locales['pt'] = {
                closeText: 'Fechar',
                prevText: 'Anterior',
                nextText: 'Próximo',
                currentText: 'Começo',
                monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
                monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun', 'Jul','Ago','Set','Out','Nov','Dez'],
                dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],
                dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb'],
                dayNamesMin: ['D','S','T','Q','Q','S','S'],
                weekHeader: 'Semana',
                firstDay: 1,
                isRTL: false,
                showMonthAfterYear: false,
                yearSuffix: '',
                timeOnlyTitle: 'Só Horas',
                timeText: 'Tempo',
                hourText: 'Hora',
                minuteText: 'Minuto',
                secondText: 'Segundo',
                currentText: 'Data Atual',
                ampm: false,
                month: 'Mês',
                week: 'Semana',
                day: 'Dia',
                allDayText : 'Todo Dia'
            };

    



window.onload = function(){        
    document.getElementById('base').style.marginTop = "-" + alturaframe() + 'px';
    document.getElementById('contente').style.marginLeft = "-" + larguraframe() + 'px';

   }

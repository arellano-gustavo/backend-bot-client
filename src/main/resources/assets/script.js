var synth = window.speechSynthesis;
var voices = [];

function populateVoiceList() {
    voices = synth.getVoices().sort(function(a, b) {
        const aname = a.name.toUpperCase(),
            bname = b.name.toUpperCase();
        if (aname < bname) return -1;
        else if (aname == bname) return 0;
        else return +1;
    });
}

populateVoiceList();
if (speechSynthesis.onvoiceschanged !== undefined) {
    speechSynthesis.onvoiceschanged = populateVoiceList;
}

function speak(texto) {
    if (synth.speaking) {
        console.error('speechSynthesis.speaking');
        return;
    }
    if (texto !== '') {
        var utterThis = new SpeechSynthesisUtterance(texto);
        utterThis.onend = function(event) {
            console.log('SpeechSynthesisUtterance.onend');
        }
        utterThis.onerror = function(event) {
            console.error('SpeechSynthesisUtterance.onerror');
        }
		
		for(i = 0; i < voices.length ; i++) {
		  if(voices[i].name === 'Microsoft Sabina Desktop - Spanish (Mexico)') {
			utterThis.voice = voices[i];
			break;
		  }
		}
		
        utterThis.pitch = 1;
        utterThis.rate = 1;
        synth.speak(utterThis);
    }
}
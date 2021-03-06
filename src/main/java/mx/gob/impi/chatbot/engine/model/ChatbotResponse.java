package mx.gob.impi.chatbot.engine.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ChatbotResponse {
    private String calculado;
    private String conteo;
    private String localAddress;
    private String remoteAddress;
    private long time;
    private int inputNum;
    
    @Override
    public String toString() {
        return "ChatbotResponse [calculado=" + calculado + ", localAddress=" + localAddress + ", remoteAddress=" + remoteAddress + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((localAddress == null) ? 0 : localAddress.hashCode());
        result = prime * result + ((calculado == null) ? 0 : calculado.hashCode());
        result = prime * result + ((remoteAddress == null) ? 0 : remoteAddress.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ChatbotResponse other = (ChatbotResponse) obj;
        if (localAddress == null) {
            if (other.localAddress != null)
                return false;
        } else if (!localAddress.equals(other.localAddress))
            return false;
        if (calculado == null) {
            if (other.calculado != null)
                return false;
        } else if (!calculado.equals(other.calculado))
            return false;
        if (remoteAddress == null) {
            if (other.remoteAddress != null)
                return false;
        } else if (!remoteAddress.equals(other.remoteAddress))
            return false;
        return true;
    }

    public Map<String, Object> build() throws Exception {
        Map<String, String> info = new HashMap<String, String>();
        //info.put("RemoteAddress", request.remoteAddress().host()+":"+request.remoteAddress().port());
        info.put("Input Num", this.inputNum+"");
        info.put("Calculated Num", this.conteo);
        info.put("Current Node IP", this.localAddress);
        info.put("Caller IP", this.remoteAddress);
        Date now = new Date();
        info.put("Call Timestamp", now.toString());
        info.put("Calc time", this.time+ " milisegundos");
        info.put("version", "3.1.4");
        
        Map<String, Object> resp = new HashMap<String, Object>();
        resp.put("result", calculado);
        resp.put("info", info);
        return resp;
    }
}

// Copyright (c) 2015 firsh.ME
package fuck.gfw.rudp.message;


import fuck.gfw.rudp.RUDPConfig;

import java.net.DatagramPacket;
import java.net.InetAddress;

public abstract class Message {
	
	protected short ver= RUDPConfig.protocal_ver;
	protected short sType=0;
	protected DatagramPacket dp;
	public int connectId;
	public int clientId;
	public int getSType(){
		return sType;
	}
	public int getVer(){
		return ver;
	}
	public DatagramPacket getDatagramPacket(){
		return dp;
	}
	public void setDstAddress(InetAddress dstIp){
		dp.setAddress(dstIp);
	}
	public void setDstPort(int dstPort){
		dp.setPort(dstPort);
	}
	public int getConnectId() {
		return connectId;
	}
	public void setConnectId(int connectId) {
		this.connectId = connectId;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	
}

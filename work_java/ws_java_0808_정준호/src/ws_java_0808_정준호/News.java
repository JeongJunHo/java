package ws_java_0808_정준호;

class News {
	private int hour;
	private double temp;
	private String wfKor;
	private int reh;
	/**
	 * @return the hour
	 */
	public int getHour() {
		return hour;
	}
	/**
	 * @param hour the hour to set
	 */
	public void setHour(int hour) {
		this.hour = hour;
	}
	/**
	 * @return the temp
	 */
	public double getTemp() {
		return temp;
	}
	/**
	 * @param temp the temp to set
	 */
	public void setTemp(double temp) {
		this.temp = temp;
	}
	/**
	 * @return the kfKor
	 */
	public String getWfKor() {
		return wfKor;
	}
	/**
	 * @param kfKor the kfKor to set
	 */
	public void setWfKor(String wfKor) {
		this.wfKor = wfKor;
	}
	/**
	 * @return the reh
	 */
	public int getReh() {
		return reh;
	}
	/**
	 * @param reh the reh to set
	 */
	public void setReh(int reh) {
		this.reh = reh;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Weather [hour=" + hour + ", temp=" + temp + ", wfKor=" + wfKor + ", reh=" + reh + "]";
	}
}

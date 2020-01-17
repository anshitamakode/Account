package com.beans;

public class Account  {
	private int accNo;
	private String accType;
	private float accBal;
	private static int count=1000;

	public Account()
	{
		this.accNo=0;
		this.accType=null;
		this.accBal=0.0f;

	}
	public Account(String accType,float accBal)
	{
		this.accNo=count;
		count++;
		this.accType=accType;
		this.accBal=accBal;
	}

	public int getAccNo() {
		return accNo;
	}



	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}



	public String getAcctype() {
		return accType;
	}



	public void setAcctype(String acctype) {
		this.accType = accType;
	}



	public float getAccBal() {
		return accBal;
	}



	public void setAccBal(float accBal) {
		this.accBal = accBal;
	}
	public String toString()
	{
		return "AccNo: "+accNo+" AccType: "+accType+" AccBal: "+accBal;

	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(accBal);
		result = prime * result + accNo;
		result = prime * result + ((accType == null) ? 0 : accType.hashCode());
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
		Account other = (Account) obj;
		if (Float.floatToIntBits(accBal) != Float.floatToIntBits(other.accBal))
			return false;
		if (accNo != other.accNo)
			return false;
		if (accType == null) {
			if (other.accType != null)
				return false;
		} else if (!accType.equals(other.accType))
			return false;
		return true;
	}



}



package edu.ssafy.chap05;

public class Manager {
	private Employee[] arr;
	private int max = 10;
	private int index = 0;
	
	public Manager() {
		arr = new Employee[max];
	}
	
	public int addEmployee(Employee e) {
		if(index < max) {
			arr[index] = e;
		}else {
			Employee[] emp = new Employee[max*2];
			max*=2;
			System.arraycopy(arr, 0, emp, 0, arr.length);
			arr = emp;
			arr[index] = e;
		}
		index++;
		return index;
	}
	
	public void toWork() {
		for (int i = 0; i < index; i++) {
			if(arr[i] instanceof Programmer) {
				Programmer p = (Programmer)arr[i];
				p.삽질();
			}else if(arr[i] instanceof Teacher) {
				Teacher p = (Teacher)arr[i];
				p.쉽니다();
			}
			arr[i].work();
		}
	}
}

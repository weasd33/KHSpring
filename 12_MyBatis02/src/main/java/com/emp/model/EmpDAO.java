package com.emp.model;

import java.util.List;

public interface EmpDAO {
	
	public List<EmpDTO> getEmpList();
	public int insertEmp(EmpDTO dto);
	public EmpDTO getEmp(int empno);
	public int updateEmp(EmpDTO dto);
	public int deleteEmp(int empno);
	public List<DeptDTO> getDeptList();
	public List<EmpDTO> getMgrList();
	public List<String> getJobList();
}

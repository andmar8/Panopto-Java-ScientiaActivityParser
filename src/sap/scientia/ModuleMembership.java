    /*
     * This file is part of Panopto-Java-ScientiaActivityParser.
     * 
     * Panopto-Java-ScientiaActivityParser is free software: you can redistribute it and/or modify
     * it under the terms of the GNU General Public License as published by
     * the Free Software Foundation, either version 3 of the License, or
     * (at your option) any later version.
     * 
     * Panopto-Java-ScientiaActivityParser is distributed in the hope that it will be useful,
     * but WITHOUT ANY WARRANTY; without even the implied warranty of
     * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
     * GNU General Public License for more details.
     * 
     * You should have received a copy of the GNU General Public License
     * along with Panopto-Java-ScientiaActivityParser.  If not, see <http://www.gnu.org/licenses/>.
     * 
     * Copyright: Andrew Martin, Newcastle University
     * 
     */
package sap.scientia;

//org
import org.w3c.dom.Node;

public class ModuleMembership extends AbstractScientiaObject
{
    private String department_HostKey;
    private String department_Id;
    private String department_Name;
    private String module_HostKey;
    private String module_Id;
    private String module_Name;
    private String staff_Active;
    private String staff_Description;
    private String staff_Email;
    private String staff_HostKey;
    private String staff_Id;
    private String staff_Name;

    public ModuleMembership(Node mm)
    {
        this.department_HostKey = getStringFromNode(mm, "Department_HostKey");
        this.department_Id = getStringFromNode(mm, "Department_Id");
        this.department_Name = getStringFromNode(mm, "Department_Name");
        this.module_HostKey = getStringFromNode(mm, "Module_HostKey");
        this.module_Id = getStringFromNode(mm, "Module_Id");
        this.module_Name = getStringFromNode(mm, "Module_Name");
        this.staff_Active = getStringFromNode(mm, "Staff_Active");
        this.staff_Description = getStringFromNode(mm, "Staff_Description");
        this.staff_Email = getStringFromNode(mm,"Staff_Email");
        this.staff_HostKey = getStringFromNode(mm, "Staff_HostKey");
        this.staff_Id = getStringFromNode(mm, "Staff_Id");
        this.staff_Name = getStringFromNode(mm, "Staff_Name");
    }

    public String getStaff_Email() {
        return staff_Email;
    }

    public void setStaff_Email(String staff_Email) {
        this.staff_Email = staff_Email;
    }

    public String getDepartment_HostKey() {
        return department_HostKey;
    }

    public void setDepartment_HostKey(String department_HostKey) {
        this.department_HostKey = department_HostKey;
    }

    public String getDepartment_Id() {
        return department_Id;
    }

    public void setDepartment_Id(String department_Id) {
        this.department_Id = department_Id;
    }

    public String getDepartment_Name() {
        return department_Name;
    }

    public void setDepartment_Name(String department_Name) {
        this.department_Name = department_Name;
    }

    public String getModule_HostKey() {
        return module_HostKey;
    }

    public void setModule_HostKey(String module_HostKey) {
        this.module_HostKey = module_HostKey;
    }

    public String getModule_Id() {
        return module_Id;
    }

    public void setModule_Id(String module_Id) {
        this.module_Id = module_Id;
    }

    public String getModule_Name() {
        return module_Name;
    }

    public void setModule_Name(String module_Name) {
        this.module_Name = module_Name;
    }

    public String getStaff_Active() {
        return staff_Active;
    }

    public void setStaff_Active(String staff_Active) {
        this.staff_Active = staff_Active;
    }

    public String getStaff_Description() {
        return staff_Description;
    }

    public void setStaff_Description(String staff_Description) {
        this.staff_Description = staff_Description;
    }

    public String getStaff_HostKey() {
        return staff_HostKey;
    }

    public void setStaff_HostKey(String staff_HostKey) {
        this.staff_HostKey = staff_HostKey;
    }

    public String getStaff_Id() {
        return staff_Id;
    }

    public void setStaff_Id(String staff_Id) {
        this.staff_Id = staff_Id;
    }

    public String getStaff_Name() {
        return staff_Name;
    }

    public void setStaff_Name(String staff_Name) {
        this.staff_Name = staff_Name;
    }
}

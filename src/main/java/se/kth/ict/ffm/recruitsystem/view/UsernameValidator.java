/*    
 *     RecruitSystem - a distributed application to handle job applications.
 *     Copyright (C) 2014  Federico Klappenbach, Fredrik Johansson, Mikael Tenhunen
 * 
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 * 
 *     You should have received a copy of the GNU General Public License
 *      along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package se.kth.ict.ffm.recruitsystem.view;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


class UsernameValidator implements ConstraintValidator<Username, String>{

    @Override
    public void initialize(Username constraintAnnotation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

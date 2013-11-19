package com.redhat.victims.cli.commands;

/*
 * #%L
 * This file is part of victims-client.
 * %%
 * Copyright (C) 2013 The Victims Project
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */

import com.redhat.victims.VictimsException;
import com.redhat.victims.database.VictimsDB;
import com.redhat.victims.database.VictimsDBInterface;
import java.util.List;

/**
 * @author gm
 */
public class LastUpdateCommand  implements Command {

    Usage help;
    public LastUpdateCommand(){
        help = new Usage(getName(), "returns the last time the database was updated");
        help.addExample("");
    }
  
    @Override
    public final String getName() {
        return "last-update";
    }

    @Override
    public CommandResult execute(List<String> args) {
          try { 
            VictimsDBInterface db = VictimsDB.db();       
            return new ExitSuccess(db.lastUpdated().toString());
                    
        } catch (VictimsException e){
            return new ExitFailure(e.getMessage());
        }
    }

    @Override
    public String usage() {
        return help.toString();
    }
    
}

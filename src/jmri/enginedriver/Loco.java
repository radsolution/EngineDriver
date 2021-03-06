/*Copyright (C) 2017 M. Steve Todd mstevetodd@gmail.com

This program is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package jmri.enginedriver;

//
// EngineDriver Loco
//
public class Loco {
    private final String addr;                  //L2531 form
    private final String formatAddr;            //2531(L) form
    //TODO: eliminate stored formatted address and create on the fly?
    private String desc;                        //typically the roster name
    private String rosterName;                  //null if loco has no roster entry
    private boolean confirmed;                  //set after WiT responds that engine is assigned to throttle

    public Loco(String address) {
        if (address != null)
            this.addr = address;
        else
            this.addr = "";
        this.formatAddr = formatAddress();
        this.desc = "";
        this.confirmed = false;
        this.rosterName = null;
    }

    public Loco(Loco l) {
        this(l.addr);
        this.desc = l.desc;
        this.rosterName = l.rosterName;
        this.confirmed = l.confirmed;
    }

    public boolean isConfirmed() {
        return this.confirmed;
    }

    public void setConfirmed() {
        setConfirmed(true);
    }

    public void setConfirmed(boolean state) {
        this.confirmed = state;
    }

    public String getAddress() {
        return this.addr;
    }

    public String getFormatAddress() {
        return this.formatAddr;
    }

    public void setDesc(String rosterName) {
        this.desc = rosterName;
    }

    public String getDesc() {
        return this.desc;
    }
    public String getRosterName() {
        return this.rosterName;
    }
    public void setRosterName(String rosterName) {
        this.rosterName = rosterName;
    }

    //provide description if present, otherwise provide formatted address
    @Override
    public String toString() {
        return (this.desc.length() > 0 ? this.desc : this.formatAddr);
    }

    private String formatAddress() {
        return this.addr.substring(1) + "(" + this.addr.substring(0, 1) + ")";  //reformat from L2591 to 2591(L)
    }
}
    
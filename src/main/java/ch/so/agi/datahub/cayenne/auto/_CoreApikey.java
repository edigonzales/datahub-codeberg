package ch.so.agi.datahub.cayenne.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.property.DateProperty;
import org.apache.cayenne.exp.property.EntityProperty;
import org.apache.cayenne.exp.property.ListProperty;
import org.apache.cayenne.exp.property.PropertyFactory;
import org.apache.cayenne.exp.property.StringProperty;

import ch.so.agi.datahub.cayenne.CoreOrganisation;
import ch.so.agi.datahub.cayenne.DeliveriesDelivery;

/**
 * Class _CoreApikey was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _CoreApikey extends BaseDataObject {

    private static final long serialVersionUID = 1L;

    public static final String T_ID_PK_COLUMN = "t_id";

    public static final StringProperty<String> APIKEY = PropertyFactory.createString("apikey", String.class);
    public static final DateProperty<LocalDateTime> CREATEDAT = PropertyFactory.createDate("createdat", LocalDateTime.class);
    public static final DateProperty<LocalDateTime> DATEOFEXPIRY = PropertyFactory.createDate("dateofexpiry", LocalDateTime.class);
    public static final DateProperty<LocalDateTime> REVOKEDAT = PropertyFactory.createDate("revokedat", LocalDateTime.class);
    public static final EntityProperty<CoreOrganisation> CORE_ORGANISATION = PropertyFactory.createEntity("coreOrganisation", CoreOrganisation.class);
    public static final ListProperty<DeliveriesDelivery> DELIVERIES_DELIVERIES = PropertyFactory.createList("deliveriesDeliveries", DeliveriesDelivery.class);

    protected String apikey;
    protected LocalDateTime createdat;
    protected LocalDateTime dateofexpiry;
    protected LocalDateTime revokedat;

    protected Object coreOrganisation;
    protected Object deliveriesDeliveries;

    public void setApikey(String apikey) {
        beforePropertyWrite("apikey", this.apikey, apikey);
        this.apikey = apikey;
    }

    public String getApikey() {
        beforePropertyRead("apikey");
        return this.apikey;
    }

    public void setCreatedat(LocalDateTime createdat) {
        beforePropertyWrite("createdat", this.createdat, createdat);
        this.createdat = createdat;
    }

    public LocalDateTime getCreatedat() {
        beforePropertyRead("createdat");
        return this.createdat;
    }

    public void setDateofexpiry(LocalDateTime dateofexpiry) {
        beforePropertyWrite("dateofexpiry", this.dateofexpiry, dateofexpiry);
        this.dateofexpiry = dateofexpiry;
    }

    public LocalDateTime getDateofexpiry() {
        beforePropertyRead("dateofexpiry");
        return this.dateofexpiry;
    }

    public void setRevokedat(LocalDateTime revokedat) {
        beforePropertyWrite("revokedat", this.revokedat, revokedat);
        this.revokedat = revokedat;
    }

    public LocalDateTime getRevokedat() {
        beforePropertyRead("revokedat");
        return this.revokedat;
    }

    public void setCoreOrganisation(CoreOrganisation coreOrganisation) {
        setToOneTarget("coreOrganisation", coreOrganisation, true);
    }

    public CoreOrganisation getCoreOrganisation() {
        return (CoreOrganisation)readProperty("coreOrganisation");
    }

    public void addToDeliveriesDeliveries(DeliveriesDelivery obj) {
        addToManyTarget("deliveriesDeliveries", obj, true);
    }

    public void removeFromDeliveriesDeliveries(DeliveriesDelivery obj) {
        removeToManyTarget("deliveriesDeliveries", obj, true);
    }

    @SuppressWarnings("unchecked")
    public List<DeliveriesDelivery> getDeliveriesDeliveries() {
        return (List<DeliveriesDelivery>)readProperty("deliveriesDeliveries");
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "apikey":
                return this.apikey;
            case "createdat":
                return this.createdat;
            case "dateofexpiry":
                return this.dateofexpiry;
            case "revokedat":
                return this.revokedat;
            case "coreOrganisation":
                return this.coreOrganisation;
            case "deliveriesDeliveries":
                return this.deliveriesDeliveries;
            default:
                return super.readPropertyDirectly(propName);
        }
    }

    @Override
    public void writePropertyDirectly(String propName, Object val) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch (propName) {
            case "apikey":
                this.apikey = (String)val;
                break;
            case "createdat":
                this.createdat = (LocalDateTime)val;
                break;
            case "dateofexpiry":
                this.dateofexpiry = (LocalDateTime)val;
                break;
            case "revokedat":
                this.revokedat = (LocalDateTime)val;
                break;
            case "coreOrganisation":
                this.coreOrganisation = val;
                break;
            case "deliveriesDeliveries":
                this.deliveriesDeliveries = val;
                break;
            default:
                super.writePropertyDirectly(propName, val);
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        writeSerialized(out);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        readSerialized(in);
    }

    @Override
    protected void writeState(ObjectOutputStream out) throws IOException {
        super.writeState(out);
        out.writeObject(this.apikey);
        out.writeObject(this.createdat);
        out.writeObject(this.dateofexpiry);
        out.writeObject(this.revokedat);
        out.writeObject(this.coreOrganisation);
        out.writeObject(this.deliveriesDeliveries);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.apikey = (String)in.readObject();
        this.createdat = (LocalDateTime)in.readObject();
        this.dateofexpiry = (LocalDateTime)in.readObject();
        this.revokedat = (LocalDateTime)in.readObject();
        this.coreOrganisation = in.readObject();
        this.deliveriesDeliveries = in.readObject();
    }

}

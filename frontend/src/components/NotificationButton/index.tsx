import axios from "axios";
import icon from "../../assets/img/notification-icon.svg";
import './styless.css'
import { BASE_URL } from "../../utils/request";
import { toast } from "react-toastify";


type Props = {
  saleId : number;
}

function handleClick(id : number){
  axios(`${BASE_URL}/sales/${id}/notification`)
  .then(() => {
      toast.info("SMS send");
    });
  }

function NotificationButton({saleId} : Props) {
 
    return (
        <>
       <div className="dsmeta-red-btn" onClick={() => handleClick(saleId)}>
        <img src={icon} alt="Notificar" />
     </div>
       </>
    )
  }
  
  export default NotificationButton
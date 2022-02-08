function messages(infoMsg) {
	const swal = Swal;
	const msg = infoMsg;
	switch (msg) {

		case 'Successfully Added':
			var toastMixin1 = swal.mixin({
				toast: true,
				icon: 'success',
				title: 'General Title',
				animation: false,
				position: 'top-right',
				showConfirmButton: false,
				timer: 2500,
				timerProgressBar: true,
				didOpen: (toast) => {
					toast.addEventListener('mouseenter', Swal.stopTimer)
					toast.addEventListener('mouseleave', Swal.resumeTimer)
				}
			});


			toastMixin1.fire({
				animation: true,
				title: 'Task Added Successfully'
			});
			break;

		case 'Not Added':

			var toastMixin2 = swal.mixin({
				toast: true,
				icon: 'warning',
				title: 'General Title',
				animation: false,
				position: 'top-right',
				showConfirmButton: false,
				timer: 2500,
				timerProgressBar: true,
				didOpen: (toast) => {
					toast.addEventListener('mouseenter', Swal.stopTimer)
					toast.addEventListener('mouseleave', Swal.resumeTimer)
				}
			});


			toastMixin2.fire({
				animation: true,
				title: 'Task Not Added'
			});
			break;
		case 'Already Exist':
			var toastMixin3 = swal.mixin({
				toast: true,
				icon: 'warning',
				title: 'General Title',
				animation: false,
				position: 'top-right',
				showConfirmButton: false,
				timer: 2500,
				timerProgressBar: true,
				didOpen: (toast) => {
					toast.addEventListener('mouseenter', Swal.stopTimer)
					toast.addEventListener('mouseleave', Swal.resumeTimer)
				}
			});


			toastMixin3.fire({
				animation: true,
				title: 'Task Already Assigned'
			});
			break;
	}

}